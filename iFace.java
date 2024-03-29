import java.util.Scanner;

public class iFace
{
    static int logado;
    static Scanner input= new Scanner(System.in);
    static String Usuarios[]= new String[50];
    static boolean UsersCheck[] = new boolean[50];
    static String Senha[]= new String[50];
    static String Nickname[]= new String[50];
    static boolean Amigos[][]= new boolean[50][50];
    static boolean Pedidosdeamizade[][]= new boolean[50][50];
    static String Mensagens[][][]= new String[50][50][50];
    static String Comunidades[][]= new String[50][51];
    static String Descricao[]= new String[50];




    public static void main(String[] args)
    {
        
        int option = 0;
        while(option != 3)
        {
            System.out.println("Bem vindo ao iFace!");
            System.out.println("[1] - Entrar");
            System.out.println("[2] - Criar conta");
            System.out.println("[3] - Sair");
            option = input.nextInt();
            input.nextLine();
            clear();
            if(option == 1)
            {
                if(checklogin()==true)
                {
                    int option2=0;
                    while(option2!=7)
                    {
                        System.out.println("--iFace--");
                        System.out.println("[1] - Perfil");
                        System.out.println("[2] - Editar Perfil");
                        System.out.println("[3] - Amigos");
                        System.out.println("[4] - Mensagens");
                        System.out.println("[5] - Comunidades");
                        System.out.println("[6] - Deletar Perfil");
                        System.out.println("[7] - Sair");
                        option2=input.nextInt();
                        input.nextLine();
                        clear();

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
                            clear();
                        
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
                clear();  
        }


    }

    public static void addUser()
    {
        int i;
        for(i=0;i<50;i++)
        {
            if(UsersCheck[i]==false)
            {
                UsersCheck[i]=true;
                break;
            }
        }
        if(i>=50)
        {
            System.out.println("Capacidade máxima atingida");
            return;
        }
        System.out.println("Digite o seu nome de Usuário:");
        String user=input.nextLine();
        for(int j=0;j<50;j++)
        {
            if(user.equals(Usuarios[j]))
            {
                UsersCheck[i]=false;
                System.out.println("Nome de Usuário indisponível");
                clear();
                return;
            }
        }
        Usuarios[i]=user;
        System.out.println("Digite a sua senha: ");
        Senha[i]=input.nextLine();
        System.out.println("Digite o seu Nickname: ");
        Nickname[i]=input.nextLine();
        System.out.println("Conta criada com sucesso!");
        clear();

    }

    public static boolean checklogin()
    {
        System.out.println("Nome de Usuario: ");
        String user= input.nextLine();
        System.out.println("Senha: ");
        String senha= input.nextLine();
        clear();
        for(int i=0;i<50;i++)
        {
            if(user.equals(Usuarios[i]) && senha.equals(Senha[i]))
            {
                System.out.println("Login feito com sucesso!");
                logado=i;
                clear();
                return true;
            }
        }
        System.out.println("Usuário ou Senha incorreto.");
        clear();
        return false;
    }

    public static void printProfile()
    {
        System.out.format("Nome de usuário: %s%n", Usuarios[logado]);
        System.out.format("Nickname: %s%n", Nickname[logado]);
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
            System.out.println("[3] - Nickname");
            System.out.println("[4] - Voltar");
            op = input.nextInt();
            input.nextLine();
            clear();
            if(op==1)
            {
                System.out.println("Digite o novo nome de Usuário:");
                Usuarios[logado]=input.nextLine();
                System.out.println("Nome de Usuário alterado.");
                clear();
            }
            else if(op==2)
            {
                System.out.println("Digite a nova Senha:");
                Senha[logado]=input.nextLine();
                System.out.println("Senha alterada.");
                clear();
            }
            else if(op==3)
            {
                System.out.println("Digite o novo nick:");
                Nickname[logado]=input.nextLine();
                System.out.println("Nickname alterado.");
                clear();
            }
            else if(op==4);

            else
                System.out.println("Opção Inválida.");
                clear();   
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
            input.nextLine();
            clear();
            if(op==1)
            {
                flag=0;
                System.out.println("Amigos:");
                for(int i=0;i<50;i++)
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
                    clear();
                }
            }
            else if(op==2)
            {
                flag=0;
                System.out.println("Digite o Nickname do Usuário:");
                String amigo=input.nextLine();
                for(int i=0;i<50;i++)
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
                            clear();
                        }
                        flag=1;
                    }
                }
                if(flag!=1)
                {
                    System.out.println("Usuário não encontrado.");
                    clear();
                }
            }
            else if(op==3)
            {
                flag=0;
                for(int i=0;i<50;i++)
                {
                    if(Pedidosdeamizade[logado][i]==true)
                    {
                        System.out.format("%s deseja ser seu amigo.%n",Nickname[i]);
                        System.out.format("Deseja confirmar a amizade com %s?%n",Nickname[i]);
                        System.out.println("[1] - Sim");
                        System.out.println("[2] - Não");
                        int op2=input.nextInt();
                        input.nextLine();
                        if(op2==1)
                        {
                            Amigos[logado][i]=true;
                            Pedidosdeamizade[logado][i]=false;
                            System.out.println("Pedido de amizade aceito");

                        }
                        else if(op2==2)
                        {
                            Pedidosdeamizade[logado][i]=false;
                            Amigos[i][logado]=false;
                            System.out.println("Pedido de amizade recusado.");
                        }   
                    }
                }
                if(flag!=1)
                {
                    System.out.println("Você não possui pedidos de amizade.");
                    clear();
                }
                else
                {
                    System.out.println("Você não possui mais pedidos de amizade.");
                    clear();
                }
            }
            else if(op==4);

            else
                System.out.println("Opção Inválida");
                clear();
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
            input.nextLine();
            clear();
            if(op==1)
            {
                flag=0;
                System.out.println("Digite o Nickname do Usuário para quem deseja enviar uma mensagem:");
                String nome=input.nextLine();
                for(int i=0;i<50;i++)
                {
                    if(nome.equals(Nickname[i]))
                    {
                        int j=0;
                        for(j=0;j<50;j++)
                        {
                            if(Mensagens[i][logado][j]==null)
                            {
                                System.out.format("Digite a Mensagem a ser enviada para %s:%n", Nickname[i]);
                                Mensagens[i][logado][j]=input.nextLine();
                                flag=1;
                                System.out.println("Mensagem Enviada.");
                                clear();
                                break;   
                            }
                        }
                        if(j==50)
                        {
                            System.out.println("O Usuário não pode receber mais mensagens.");
                            clear();
                        }
                    }
                }
                if(flag!=1)
                {
                    System.out.println("Usuário não encontrado");
                    clear();
                }
            }
            else if(op==2)
            {
                flag=0;
                for(int i=0;i<50;i++)
                {
                    for(int j=0;j<50;j++)
                    {
                        if(Mensagens[logado][i][j]!=null)
                        {
                            flag=1;
                            System.out.format("Mensagem de %s:%n", Nickname[i]);
                            System.out.format("%s%n%n", Mensagens[logado][i][j]);
                        }
                    }   
                }
                if(flag!=1)
                {
                    System.out.println("Você não possui mensagens");
                    clear();
                }
            }
            else if(op==3);

            else
                System.out.println("Opção Inválida");
                clear();
        }
    }

    public static void Community()
    {
        int op=0;
        int flag=0;
        while(op!=5)
        {
            System.out.println("--Comunidades--");
            System.out.println("[1] - Criar Comunidade");
            System.out.println("[2] - Entrar em uma Comunidade");
            System.out.println("[3] - Administrar a sua Comunidade");
            System.out.println("[4] - Lista de Comunidades que você faz parte");
            System.out.println("[5] - Voltar");
            op=input.nextInt();
            input.nextLine();
            clear();
            if(op==1)
            {
                flag=0;
                if(Comunidades[logado][50]==null)
                {
                    System.out.println("Digite o nome desejado para a sua Comunidade");
                    String nome=input.nextLine();
                    for(int i=0;i<50;i++)
                    {
                        if(nome.equals(Comunidades[i][50]))
                        {                                  
                                System.out.println("Já existe uma comunidade com esse nome.");
                                clear();
                                flag=1;  
                        }
                    }
                    if(flag!=1)
                    {
                        Comunidades[logado][50]=nome;   
                        System.out.println("Digite uma descrição para a sua Comunidade");
                        Descricao[logado]=input.nextLine();
                        System.out.println("Comunidade criada com sucesso!");
                        Comunidades[logado][logado]=Usuarios[logado];
                        clear();
                    }
                }
                else
                {
                    System.out.println("Você já possui uma Comunidade!");
                    clear();
                }
            }
            else if(op==2)
            {
                flag=0;
                System.out.println("Comunidades existentes:");
                for(int i=0;i<50;i++)
                {
                        if(Comunidades[i][50]!=null)
                        {                                  
                                System.out.format("[%d] - Comunidade: %s %nDescrição: %s%nAdm: %s%n%n", i+1,Comunidades[i][50],Descricao[i],Usuarios[i]);  
                                flag=1;  
                        }
                }
                if(flag!=1)
                {
                    System.out.println("Nenhuma.");
                    clear();
                }
                else
                {
                    int op2=1;
                    while(op2!=0)
                    {
                        System.out.println("Digite o número correspondente a comunidade que deseja entrar ou Digite 0 para sair.");
                        op2=input.nextInt();
                        input.nextLine();
                        clear();
                        if(op2>0 && op2<51)
                        {
                            if(Comunidades[op2-1][logado]==null)
                            {
                                Comunidades[op2-1][logado]=Usuarios[logado];
                                System.out.format("Bem vindo a comunidade %s!%n%n%n", Comunidades[op2-1][50]);
                            }
                            else
                            {
                                System.out.format("Você já faz parte da comunidade %s%n",Comunidades[op2-1][50]);
                                clear();
                            }
                            break;
                        }

                        else if(op2==0);

                        else
                        {
                            System.out.println("Opção inválida");
                            clear();
                        }
                    }
                }
            }
            else if(op==3)
            {
                if(Comunidades[logado][50]!=null)
                {
                    int op3=0;
                    while(op3!=5)
                    {
                        flag=0;
                        System.out.println("--Sua Comunidade--");
                        System.out.println("[1] - Informações da sua Comunidade");
                        System.out.println("[2] - Alterar o Nome da sua Comunidade");
                        System.out.println("[3] - Alterar a Descrição da sua Comunidade");
                        System.out.println("[4] - Expulsar membro da sua Comunidade");
                        System.out.println("[5] - Voltar");
                        op3=input.nextInt();
                        input.nextLine();
                        clear();
                        if(op3==1)
                        {
                            System.out.format("Nome: %s%n", Comunidades[logado][50]);
                            System.out.format("Descrição: %s%n", Descricao[logado]);
                            System.out.format("Adm: %s%n", Usuarios[logado]);
                            System.out.println("Membros:");
                            for(int i=0;i<50;i++)
                            {
                                if(Comunidades[logado][i]!=null && Comunidades[logado][i].equals(Usuarios[logado])==false)
                                {
                                    System.out.format("%s%n", Comunidades[logado][i]);
                                    flag=1;
                                }
                            }
                            if(flag!=1)
                            {
                                System.out.println("Nenhum.\n");
                            }
                        }
                        else if(op3==2)
                        {
                            System.out.println("Digite o novo nome da Comunidade:");
                            String nome=input.nextLine();
                            for(int i=0;i<50;i++)
                            {
                                if(nome.equals(Comunidades[i][50]))
                                {                                  
                                        System.out.println("Já existe uma comunidade com esse nome.");
                                        clear();
                                        flag=1;  
                                }
                            }
                            if(flag!=1)
                            {
                                System.out.println("Nome da Comunidade alterado.");
                                Comunidades[logado][50]=nome;
                                clear();
                            }
                        }
                        else if(op3==3)
                        {
                            System.out.println("Digite a nova Descrição da Comunidade:");
                            Descricao[logado]=input.nextLine();
                            System.out.println("Descrição da Comunidade alterada.");
                            clear();
                        }
                        else if(op3==4)
                        {
                            System.out.println("Membros:");
                            for(int i=0;i<50;i++)
                            {
                                if(Comunidades[logado][i]!=null && Comunidades[logado][i].equals(Usuarios[logado])==false)
                                {
                                    System.out.format("[%d] - %s%n", i+1,Comunidades[logado][i]);
                                    flag=1;
                                }
                            }
                            if(flag==1)
                            {
                                System.out.println("Digite o número correspondente ao membro que deseja expulsar ou digite 0 para voltar.");
                                int membro=input.nextInt();
                                input.nextLine();
                                if(membro>0 && membro<51)
                                {
                                    Comunidades[logado][membro-1]=null;
                                    System.out.println("Membro expulso com sucesso.");
                                    clear();
                                }
                                else if(membro==0);

                                else
                                {
                                    System.out.println("Opção Inválida.");
                                    clear();
                                }
                            }
                            else
                            {
                                System.out.println("A sua Comunidade não possui membros.");
                                clear();
                            }
                        }
                        else if(op3==5);
                        
                        else
                        {
                            System.out.println("Opção Inválida.");
                            clear();
                        }
                    }
                }
                else
                {
                    System.out.println("Você não ainda possui uma comunidade.");
                    clear();
                }
            }
            else if(op==4)
            {
                for(int i=0;i<50;i++)
                {
                        if(Comunidades[i][logado]!=null)
                        {                                  
                                System.out.format("Comunidade: %s %nDescrição: %s%nAdm: %s%n%n", Comunidades[i][50],Descricao[i],Usuarios[i]); 
                                flag=1;  
                        }
                }
                if(flag!=1)
                {
                    System.out.println("Você não faz parte de nenhuma Comuninade.");
                    clear();
                }
            }

            else if(op==5);

            else
            {
                System.out.println("Opção inválida");
                clear();
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
            input.nextLine();
            if(op==1)
            {
                System.out.println("Tem certeza?");
                System.out.println("[1] - Sim");
                System.out.println("[2] - Não");
                int op2 = input.nextInt();
                input.nextLine();
                if(op2 == 1)
                {
                    Usuarios[logado]=null;
                    Senha[logado]=null;
                    UsersCheck[logado]=false;
                    Nickname[logado]=null;
                    for(int i=0;i<50;i++)
                    {
                        Amigos[logado][i]=false;
                        Amigos[i][logado]=false;
                        Pedidosdeamizade[i][logado]=false;
                    }
                    for(int i=0;i<50;i++)
                    {
                        for(int j=0;j<50;j++)
                        {
                            Mensagens[i][logado][j]=null;
                        }
                    }
                    Comunidades[logado][50]=null;
                    Descricao[logado]=null;
                    for(int i=0;i<50;i++)
                    {
                        Comunidades[i][logado]=null;
                        Comunidades[logado][i]=null;   
                    }

                    System.out.println("Perfil apagado com sucesso :(");
                    return true;
                }
                else if(op2 == 2)
                {
                    System.out.println("Ainda bem :)");
                    clear();
                    return false;
                }
                else
                    System.out.println("Opção Inválida");
                    clear();

            }
            else if(op == 2)
            {
                System.out.println("Ainda bem :)");
                clear();
                return false;
            }
            else
                System.out.println("Opção Inválida");
                clear();
        }
        return true;
    }

    public static void clear()
    {
        System.out.format("%n%n");
    }

}
