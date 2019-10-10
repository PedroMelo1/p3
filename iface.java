import java.util.Scanner;

public class pp
{
    static Scanner input= new Scanner(System.in).useDelimiter("\n");
    static String Usuarios[]= new String[10];
    static boolean UsersCheck[] = new boolean[10];
    static String Senha[]= new String[10];
    static String Nascimento[]= new String[10];
    static String Cidade[]= new String[10];
    static String Estado[]= new String[10];
    static String Pais[]= new String[10];
    static String Amigos[]= new String[10];
    static int logado;




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
                if(checklogin()==true)
                {
                    int option2=0;
                    while(option2!=8)
                    {
                        System.out.println("iFace, Make friends or not, We dont care");
                        System.out.println("[1] - Profile");
                        System.out.println("[2] - Edit Profile");
                        System.out.println("[3] - Follow a friend");
                        System.out.println("[4] - Send a message");
                        System.out.println("[5] - Create a group");
                        System.out.println("[6] - Add a member to your group");
                        System.out.println("[7] - Delete profile");
                        System.out.println("[8] - Log out");
                        option2=input.nextInt();

                        if(option2 == 1)
                        {
                            printProfile();
                        }
                        else if(option2 == 2)
                        {
                            editProfile();
                        }
                        else if(option2 == 3)
                        {

                        }
                        else if(option2 == 4)
                        {
                            
                        }
                        else if(option2 == 5)
                        {
                            
                        }
                        else if(option2 == 6)
                        {
                            
                        }
                        else if(option2 == 7)
                        {
                            deleteProfile();
                        }
                        else if(option2 == 8)
                        {
                            System.out.println("Good bye");
                        }
                        else
                            System.out.println("Opção invalida");
                        
                    }
                }  

            }
            else if(option == 2)
            {
                addUser();
            }
            else if(option == 3)
            {
                System.out.println("Adeus");
            }
            else
                System.out.println("Opção invalida");  
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
        System.out.println("Digite o seu nome de Usuario:");
        String user=input.next();
        for(int j=0;j<10;j++)
        {
            if(user.equals(Usuarios[j]))
            {
                UsersCheck[i]=false;
                System.out.println("Nome de Usuario indisponível");
                return;
            }
        }
        Usuarios[i]=user;
        System.out.println("Digite a sua senha: ");
        Senha[i]=input.next();
        System.out.println("Data de nascimento(dd/mm/aaaa): ");
        Nascimento[i]=input.next();
        System.out.println("País: ");
        Pais[i]=input.next();
        System.out.println("Estado: ");
        Estado[i]=input.next();
        System.out.println("Cidade: ");
        Cidade[i]=input.next();

        System.out.println("Conta criada com sucesso!");

    }

    public static boolean checklogin()
    {
        System.out.println("Usuario: ");
        String user= input.next();
        System.out.println("Senha: ");
        String senha= input.next();
        for(int i=0;i<10;i++)
        {
            if(user.equals(Usuarios[i]) && senha.equals(Senha[i]))
            {
                System.out.println("Login feito com sucesso!");
                logado=i;
                return true;
            }
        }
        System.out.println("Usuario ou Senha incorreto");
        return false;
    }

    public static void printProfile()
    {
        System.out.format("Nome: %s%n", Usuarios[logado]);
        System.out.format("Data de Nascimento: %s%n", Nascimento[logado]);
        System.out.format("Cidade: %s%n", Cidade[logado]);
        System.out.format("Estado: %s%n", Estado[logado]);
        System.out.format("País: %s%n", Pais[logado]);
    }
    public static void editProfile()
    {
        int op = 0;
        while(op!=7)
        {
            System.out.println("O que deseja editar");
            System.out.println("[1] - Nome de usuario");
            System.out.println("[2] - Senha");
            System.out.println("[3] - Data de Nascimento");
            System.out.println("[4] - Cidade");
            System.out.println("[5] - Estado");
            System.out.println("[6] - País");
            System.out.println("[7] - Voltar");
            op = input.nextInt();
            if(op==1)
            {
                System.out.println("Digite o novo nome de Usuario:");
                Usuarios[logado]=input.next();
            }
            else if(op==2)
            {
                System.out.println("Digite a nova Senha:");
                Senha[logado]=input.next();
            }
            else if(op==3)
            {
                System.out.println("Digite a nova Data de Nascimento:");
                Nascimento[logado]=input.next();
            }
            else if(op==4)
            {
                System.out.println("Digite a nova Cidade:");
                Cidade[logado]=input.next();
            }
            else if(op==5)
            {
                System.out.println("Digite o novo Estado:");
                Estado[logado]=input.next();
            }
            else if(op==6)
            {
                System.out.println("Digite o novo País");
                Pais[logado]=input.next();
            }
            else if(op==7)
            {
                System.out.println("Voltando");   
            }
            else
                System.out.println("Opção Inválida");   
        }

    }

    public static void deleteProfile()
    {
        int op = 0;
        while(op!=2)
        {
            System.out.println("Deseja realmente apagar o seu perfil?");
            System.out.println("[1] - Sim");
            System.out.println("[2] - Não");
            op = input.nextInt();
            if(op==1)
            {
                System.out.println("Tem certeza?");
                System.out.println("[1] - Sim");
                System.out.println("[2] - Não");
                int op2 = input.nextInt();
                if(op2 == 1)
                {
                    Usuarios[logado]=null;
                    Senha[logado]=null;
                    UsersCheck[logado]=false;
                    Nascimento[logado]=null;
                    Cidade[logado]=null;
                    Estado[logado]=null;
                    Pais[logado]=null;
                    System.out.println("Perfil apagado com sucesso :(");
                    return;
                }
                else if(op2 == 2)
                {
                    System.out.println("Ainda bem :)");
                    return;
                }
                else
                    System.out.println("Opção Inválida");

            }
            else if(op == 2)
            {
                System.out.println("Ainda bem :)");
            }
            else
                System.out.println("Opção Inválida");
        }
    }

}
