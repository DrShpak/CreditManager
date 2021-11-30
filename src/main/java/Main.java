import repository.impl.ClientRepoImpl;
import repository.impl.CreditRepoImpl;
import repository.impl.TariffRepoImpl;
import services.impl.CreditServiceImpl;
import services.impl.TariffServiceImpl;

import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        var clientRepo = new ClientRepoImpl();
        var creditRepo = new CreditRepoImpl();
        var tariffRepo = new TariffRepoImpl();

        var creditSrv = new CreditServiceImpl(creditRepo, clientRepo, tariffRepo);
        var tariffSrv = new TariffServiceImpl(tariffRepo);

        var scn = new Scanner(System.in);
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
