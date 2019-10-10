import java.util.Scanner;

public class pp
{
    static Scanner input= new Scanner(System.in).useDelimiter("\n");
    static String Usuarios[]= new String[10];
    static boolean UsersCheck[] = new boolean[10];
    static String Senha[]= new String[10];




    public static void main(String[] args)
    {
        
        int option = 0;
        while(option != 3)
        {
            System.out.println("Welcome to iFace");
            System.out.println("[1] - Login");
            System.out.println("[2] - Create Account");
            System.out.println("[3] - Exit");
            option = input.nextInt();
            if(option == 1)
            {
                checklogin();

            }
            else if(option == 2)
            {
                addUser();
            }
            else if(option == 3)
            {
                System.out.println("Adeus");
            }    
        }


    }

    public static void addUser()
    {
        int i;
        for(i=0;i<10;i++)
        {
            if(UsersCheck[i]==false)
            {
                UsersCheck[i]=true;
                break;
            }
        }
        if(i>=10)
        {
            System.out.println("Capacidade maxima atingida");
            return;
        }
        System.out.println("Digite o seu nome de usuario:");
        String user=input.next();
        for(int j=0;j<10;j++)
        {
            if(user.equals(Usuarios[j]))
            {
                UsersCheck[i]=false;
                System.out.println("Nome de Usuario indisponivel");
                return;
            }
        }
        Usuarios[i]=user;
        System.out.println("Digite a sua senha:");
        Senha[i]=input.next();
    }

    public static void checklogin()
    {
        System.out.println("Usuario: ");
        String user= input.next();
        System.out.println("Senha: ");
        String senha= input.next();
        for(int i=0;i<10;i++)
        {
            if(user.equals(Usuarios[i]) && senha.equals(Senha[i]))
            {
                System.out.println("Login feito com sucesso");
                return;
            }
        }
        System.out.println("Usuario ou Senha incorreto");
    }
}