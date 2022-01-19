package neoflex;

import neoflex.model.client.Client;
import neoflex.model.tariff.Tariff;
import neoflex.repositoryHibernate.ClientRepository;
import neoflex.repositoryHibernate.TariffRepository;
import neoflex.services.impl.ClientServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import neoflex.repositoryHibernate.CreditRepository;
import neoflex.services.impl.CreditServiceImpl;
import neoflex.services.impl.TariffServiceImpl;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.UUID;

@SpringBootApplication
public class Main {
    private static ClientRepository clientRepo;
    private static CreditRepository creditRepo;
    private static TariffRepository tariffRepo;

    @Autowired
    public void setStaticRepos(ClientRepository clientRepository,
                               CreditRepository creditRepo,
                               TariffRepository tariffRepo)
    {
        Main.clientRepo = clientRepository;
        Main.creditRepo = creditRepo;
        Main.tariffRepo = tariffRepo;
    }

    @Bean
    InitializingBean fillDatabase() {
        return () -> {
            if (Main.clientRepo.count() == 0)
            {
                Main.clientRepo.save(new Client(UUID.fromString("0d791668-5d8c-4bd7-a8b7-68e0d41d7298"),
                        "Эдуард",
                        "Вениаминович",
                        "Лимонов",
                        LocalDate.parse("22.02.1946", DateTimeFormatter.ofPattern("dd.MM.yyyy"))));
                Main.clientRepo.save(new Client(UUID.fromString("2b791768-518c-4cd7-a8b7-68e0d41d7298"),
                        "Владимир",
                        "Владимирович",
                        "Путин",
                        LocalDate.parse("07.10.1952", DateTimeFormatter.ofPattern("dd.MM.yyyy"))));
                Main.clientRepo.save(new Client(UUID.fromString("8eb87bc9-30e6-4871-baaf-59fb3e76f9ab"),
                        "Андрей",
                        "Андреевич",
                        "Замай",
                        LocalDate.parse("09.11.1986", DateTimeFormatter.ofPattern("dd.MM.yyyy"))));
            }
            if (Main.tariffRepo.count() == 0)
            {
                Main.tariffRepo.save(new Tariff(UUID.fromString("ba90b2f7-1fe4-40ac-929c-6d164219498e"),
                        "lol", 10, 1000, 5
                        )
                );
                Main.tariffRepo.save(new Tariff(UUID.fromString("b3ef0d86-d846-4830-9c4d-bebb23d9adf1"),
                                "kek", 2, 500, 2
                        )
                );
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

        //var clientRepo = new ClientRepoImpl();
        //var creditRepo = new CreditRepoImpl();
        //var tariffRepo = new TariffRepoImpl();

        var clientSrv = new ClientServiceImpl(clientRepo);
        var creditSrv = new CreditServiceImpl(creditRepo, clientRepo, tariffRepo);
        var tariffSrv = new TariffServiceImpl(tariffRepo);

        var scn = new Scanner(System.in);
        //noinspection InfiniteLoopStatement
        while (true)
        {
            try {
                var cmd = scn.nextLine();
                switch (cmd)
                {
                    case "GetListTariffs" -> {
                        for (var fe:
                                tariffSrv.getListTariffs()) {
                            System.out.println(fe.toString());
                        }
                    }
                    case "GetCreditApplication" -> System.out.println(creditSrv.openCredit(UUID.fromString(scn.nextLine()),
                            UUID.fromString(scn.nextLine())));
                    case "CloseCredit" -> System.out.println(
                            creditSrv.closeCredit(UUID.fromString(scn.nextLine()),
                                    UUID.fromString(scn.nextLine())));
                    case "GetListActiveCredits" -> System.out.println(
                            creditSrv.getCreditsByClientId(UUID.fromString(scn.nextLine())));
                    case "GetListClients" -> {
                        for (var fe:
                                clientSrv.getListClients()) {
                            System.out.println(fe.toString());
                        }
                    }
                    default -> System.out.println("Unknown command");
                }
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
}
