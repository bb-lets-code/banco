public class Application {
    public static void main(String[] args) {
        ClientePF clientePF = new ClientePF(
                "João"
        );
        ClientePJ clientePJ = new ClientePJ("", "null", 0.005, 0.005);
        try {
            SavingsAccount savingsAccount = new SavingsAccount(
                clientePF,
                1
            );
                    savingsAccount.deposit(100);
                    System.out.println( savingsAccount.totalBalance());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
