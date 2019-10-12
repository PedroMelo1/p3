import java.util.Scanner;

public class iFace
{
    static int logado;
    static Scanner input= new Scanner(System.in).useDelimiter("\n");
    static String Usuarios[]= new String[10];
    static boolean UsersCheck[] = new boolean[10];
    static String Senha[]= new String[10];
    static String Nickname[]= new String[10];
    static boolean Amigos[][]= new boolean[10][10];
    static boolean Pedidosdeamizade[][]= new boolean[10][10];
    static String Mensagens[][][]= new String[10][10][10];
    static String Comunidades[][]= new String[10][11];
    static String Descricao[]= new String[10];




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
                    while(option2!=7)
                    {
                        System.out.println("iFace, Make friends or not, We dont care");
                        System.out.println("[1] - Perfil");
                        System.out.println("[2] - Editar Perfil");
                        System.out.println("[3] - Amigos");
                        System.out.println("[4] - Mensagens");
                        System.out.println("[5] - Comunidades");
                        System.out.println("[6] - Deletar Perfil");
                        System.out.println("[7] - Sair");
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
                            friends();
                        }
                        else if(option2 == 4)
                        {
                            Message();
                        }
                        else if(option2 == 5)
                        {
                            Community();
                        }
                        else if(option2 == 6)
                        {
                            if(deleteProfile()==true)
                                option2=7;
                        }
                        else if(option2 == 7)
                        {
                            System.out.println("Volte Sempre!");
                        }
                        else
                            System.out.println("Opção inválida");
                        
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
                System.out.println("Opção inválida");  
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
            System.out.println("Capacidade máxima atingida");
            return;
        }
        System.out.println("Digite o seu nome de Usuário:");
        String user=input.next();
        for(int j=0;j<10;j++)
        {
            if(user.equals(Usuarios[j]))
            {
                UsersCheck[i]=false;
                System.out.println("Nome de Usuário indisponível");
                return;
            }
        }
        Usuarios[i]=user;
        System.out.println("Digite a sua senha: ");
        Senha[i]=input.next();
        System.out.println("Digite o seu Nick: ");
        Nickname[i]=input.next();

        System.out.println("Conta criada com sucesso!");

    }

    public static boolean checklogin()
    {
        System.out.println("Nome de Usuario: ");
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
        System.out.println("Usuário ou Senha incorreto.");
        return false;
    }

    public static void printProfile()
    {
        System.out.format("Nome de usuário: %s%n", Usuarios[logado]);
        System.out.format("Nick: %s%n", Nickname[logado]);
    }
    public static void editProfile()
    {
        int op = 0;
        while(op!=4)
        {
            System.out.println("--Edição de Perfil--");
            System.out.println("O que deseja editar?");
            System.out.println("[1] - Nome de usuário");
            System.out.println("[2] - Senha");
            System.out.println("[3] - Nick");
            System.out.println("[4] - Voltar");
            op = input.nextInt();
            if(op==1)
            {
                System.out.println("Digite o novo nome de Usuário:");
                Usuarios[logado]=input.next();
            }
            else if(op==2)
            {
                System.out.println("Digite a nova Senha:");
                Senha[logado]=input.next();
            }
            else if(op==3)
            {
                System.out.println("Digite o novo nick:");
                Nickname[logado]=input.next();
            }
            else if(op==4);

            else
                System.out.println("Opção Inválida.");   
        }

    }

    public static void friends()
    {
        int op=0;
        int flag;
        while(op!=4)
        {
            System.out.println("--Amigos--");
            System.out.println("[1] - Lista de amigos");
            System.out.println("[2] - Adicionar amigos");
            System.out.println("[3] - Pedidos de amizade");
            System.out.println("[4] - Voltar");
            op=input.nextInt();
            if(op==1)
            {
                flag=0;
                System.out.println("Amigos:");
                for(int i=0;i<10;i++)
                {
                    if(Amigos[logado][i]==true && Amigos[i][logado]==true)
                    {
                        System.out.format("%s%n", Nickname[i]);
                        flag=1;                      
                    }
                }
                if(flag!=1)
                {
                    System.out.println("Você ainda não possui amigos.");
                }
            }
            else if(op==2)
            {
                flag=0;
                System.out.println("Digite o nick do Usuário:");
                String amigo=input.next();
                for(int i=0;i<10;i++)
                {
                    if(amigo.equals(Nickname[i]))
                    {
                        if(Amigos[i][logado]==true && Amigos[logado][i]==true)
                        {
                            System.out.format("%s já é seu amigo!%n", Nickname[i]);
                        }
                        else
                        {
                            Amigos[logado][i]=true;
                            Pedidosdeamizade[i][logado]=true;
                            System.out.println("Pedido de amizade enviado!");
                        }
                        flag=1;
                    }
                }
                if(flag!=1)
                {
                    System.out.println("Usuário não encontrado.");
                }
            }
            else if(op==3)
            {
                flag=0;
                for(int i=0;i<10;i++)
                {
                    if(Pedidosdeamizade[logado][i]==true)
                    {
                        System.out.format("%s deseja ser seu amigo%n",Nickname[i]);
                        System.out.format("Deseja confirmar a amizade com %s?%n",Nickname[i]);
                        System.out.println("[1] - Sim");
                        System.out.println("[2] - Não");
                        int op2=input.nextInt();
                        if(op2==1)
                        {
                            Amigos[logado][i]=true;
                            Pedidosdeamizade[logado][i]=false;
                            System.out.println("Pedido de amizade aceito.");

                        }
                        else if(op2==2)
                        {
                            Pedidosdeamizade[logado][i]=false;
                            System.out.println("Pedido de amizade recusado.");
                        }   
                    }
                }
                if(flag!=1)
                {
                    System.out.println("Você não possui pedidos de amizade.");
                }
            }
            else if(op==4);

            else
                System.out.println("Opção Inválida");
        }
    }

    public static void Message()
    {
        int op=0;
        int flag=0;
        while(op!=3)
        {
            System.out.println("--Mensagens--");
            System.out.println("[1] - Enviar Mensagem");
            System.out.println("[2] - Ler mensagens recebidas");
            System.out.println("[3] - Voltar");
            op=input.nextInt();
            if(op==1)
            {
                flag=0;
                System.out.println("Digite o nick do Usuário para quem deseja enviar uma mensagem:");
                String nome=input.next();
                for(int i=0;i<10;i++)
                {
                    if(nome.equals(Nickname[i]))
                    {
                        int j=0;
                        for(j=0;j<10;j++)
                        {
                            if(Mensagens[i][logado][j]==null)
                            {
                                System.out.format("Digite a Mensagem a ser enviada para %s:", Nickname[i]);
                                Mensagens[i][logado][j]=input.next();
                                flag=1;
                                System.out.println("Mensagem Enviada.");
                                break;   
                            }
                        }
                        if(j==10)
                        {
                            System.out.println("O Usuário não pode receber mais mensagens");
                        }
                    }
                }
                if(flag!=1)
                {
                    System.out.println("Usuário não encontrado");
                }
            }
            else if(op==2)
            {
                flag=0;
                for(int i=0;i<10;i++)
                {
                    for(int j=0;j<10;j++)
                    {
                        if(Mensagens[logado][i][j]!=null)
                        {
                            flag=1;
                            System.out.format("Mensagem de %s:%n", Nickname[i]);
                            System.out.format("%s%n", Mensagens[logado][i][j]);
                        }
                    }   
                }
                if(flag!=1)
                {
                    System.out.println("Você não possui mensagens");
                }
            }
            else if(op==3);

            else
                System.out.println("Opção Inválida");
        }
    }

    public static void Community()
    {
        int op=0;
        int flag=0;
        while(op!=4)
        {
            System.out.println("Comunidades");
            System.out.println("[1] - Criar Comunidade");
            System.out.println("[2] - Entrar em uma Comunidade");
            System.out.println("[3] - Informações da sua Comunidade");
            System.out.println("[4] - Voltar");
            op=input.nextInt();
            if(op==1)
            {
                flag=0;
                if(Comunidades[logado][0]==null)
                {
                    System.out.println("Digite o nome desejado para a sua Comunidade");
                    String nome=input.next();
                    for(int i=0;i<10;i++)
                    {
                        if(nome.equals(Comunidades[i][0]))
                        {                                  
                                System.out.println("Já existe uma comunidade com esse nome."); 
                                flag=1;  
                        }
                    }
                    if(flag!=1)
                    {
                        Comunidades[logado][0]=nome;   
                        System.out.println("Digite uma descrição para a sua Comunidade");
                        Descricao[logado]=input.next();
                        System.out.println("Comunidade criada com sucesso!");
                        Comunidades[logado][1]=Usuarios[logado];
                    }
                }
                else
                {
                    System.out.println("Você já possui uma Comunidade!");
                }
            }
            else if(op==2)
            {
                flag=0;
                System.out.println("Comunidades existentes:");
                for(int i=0;i<10;i++)
                {
                        if(Comunidades[i][0]!=null)
                        {                                  
                                System.out.format("[%d] - Nome: %s %nDescrição: %s%n%n", i+1, Comunidades[i][0], Descricao[i]); 
                                flag=1;  
                        }
                }
                if(flag!=1)
                {
                    System.out.println("Nenhuma.");
                }
                else
                {
                    int op2=1;
                    while(op2!=0)
                    {
                        System.out.println("Digite o número correspondente a comunidade que deseja entrar ou Digite 0 para sair.");
                        op2=input.nextInt();
                        if(op2>0 && op2<11)
                        {
                            if(Comunidades[op2-1][logado+1]==null)
                            {
                                Comunidades[op2-1][logado+1]=Usuarios[logado];
                                System.out.format("Bem vindo a comunidade %s%n", Comunidades[op2-1][0]);
                            }
                            else
                            {
                                System.out.format("Você já faz parte da comunidade %s%n",Comunidades[op2-1][0]);
                            }
                            break;
                        }

                        else if(op2==0);

                        else
                        {
                            System.out.println("Opção inválida");
                        }
                    }
                }
            }
            else if(op==3)
            {
                if(Comunidades[logado][0]!=null)
                {
                    System.out.format("Nome: %s%n", Comunidades[logado][0]);
                    System.out.format("Descrição: %s%n", Descricao[logado]);
                    System.out.println("Membros:");
                    for(int i=1;i<11;i++)
                    {
                        if(Comunidades[logado][i]!=null)
                        {
                            System.out.format("%s%n", Comunidades[logado][i]);
                        }
                    }
                }
                else
                {
                    System.out.println("Você não ainda possui uma comunidade.");
                }
            }
            else if(op==4);

            else
            {
                System.out.println("Opção inválida");
            }
        }
    }
    

    public static boolean deleteProfile()
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
                    Nickname[logado]=null;
                    for(int i=0;i<10;i++)
                    {
                        Amigos[logado][i]=false;
                        Amigos[i][logado]=false;
                        Pedidosdeamizade[i][logado]=false;
                    }
                    for(int i=0;i<10;i++)
                    {
                        for(int j=0;j<10;j++)
                        {
                            Mensagens[i][logado][j]=null;
                        }
                    }
                    for(int i=0;i<11;i++)
                    {
                        Comunidades[logado][i]=null;   
                    }
                    System.out.println("Perfil apagado com sucesso :(");
                    return true;
                }
                else if(op2 == 2)
                {
                    System.out.println("Ainda bem :)");
                    return false;
                }
                else
                    System.out.println("Opção Inválida");

            }
            else if(op == 2)
            {
                System.out.println("Ainda bem :)");
                return false;
            }
            else
                System.out.println("Opção Inválida");
        }
        return true;
    }

}