import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import etapa1.Arquivo;
import etapa1.Catalogo;
import etapa2.Indice;
import etapa2.Operacoes;
import etapa3.Join;
/**
 * 
 * @author bruno
 *
 */
public class Main {

    
    public static void main(String[] args) throws IOException {
        
        Scanner scanner = new Scanner(System.in);
        int op1, op2;
        
        do
        {
            System.out.println("\n=============== Trabalho Final de GBD ===============\n");
            System.out.println("Etapa a ser executada:");
            System.out.println("\n 1. Etapa 1\n 2. Etapa 2\n 3. Etapa 3\n 4. Etapa 4\n 5. Sair");
            System.out.println("\nOpção: ");
            op1 = scanner.nextInt();
            
            switch (op1)
            {
                case 1:
                    //ETAPA 1 
                    //TABELA JOGADORES
                    String[] atributosjogadores = new String[4];
                    atributosjogadores[0]="Identidade";
                    atributosjogadores[1]="Nome";
                    atributosjogadores[2]="Sexo";
                    atributosjogadores[3]="Idade";

                    String[] tiposjogadores = new String[4];
                    tiposjogadores[0]="integer";
                    tiposjogadores[1]="varchar";
                    tiposjogadores[2]="char";
                    tiposjogadores[3]="small_int";

                    //Povoando tabela jogadores
                    Catalogo c1 = new Catalogo("jogadores",4,atributosjogadores,tiposjogadores);
                    c1.criaCatalogo();
                    Arquivo a1 = new Arquivo();
                    File dadosjogadores = new File("C:/Users/bruno/eclipse-workspace/trabalhoGBD/jogadores.txt");
                    a1.carregaDados(c1, dadosjogadores);

                    //TABELA TIME
                    String[] atributostime = new String[2];
                    atributostime[0]="Timejogador";
                    atributostime[1]="Time";

                    String[] tipostime = new String[2];
                    tipostime[0]="integer";
                    tipostime[1]="varchar";

                    //Povoando tabela time
                    Catalogo c2 = new Catalogo("time",2,atributostime,tipostime);
                    c2.criaCatalogo();
                    Arquivo a2 = new Arquivo();
                    File dadostime = new File("C:/Users/bruno/eclipse-workspace/trabalhoGBD/time.txt");
                    a2.carregaDados(c2, dadostime);
                    
                    break;
                    
                case 2:
                    //ETAPA 2 =============================================================================
                    //Indice da tabela jogadores
                    Indice i1 = new Indice("jogadores",c1);
                    i1.criaIndice();

                    //Indice da tabela time
                    Indice i2 = new Indice("time",c2);
                    i2.criaIndice();

                    Operacoes o = new Operacoes();
                    do
                    {
                        System.out.println("\n=============== Etapa 2 ===============\n");
                        System.out.println("Seleciona a operação desejada:\n");
                        System.out.println(" 1. Busca\n 2. Inserção\n 3. Remoção\n 4. Voltar");
                        System.out.println("\nOpção: ");
                        op2 =  scanner.nextInt();
                        
                        switch(op2)
                        {
                            case 1:
                                //Select
                                String resultado = o.select(98721, c1);
                                System.out.println(resultado);
                                
                                break;
                                
                            case 2:
                                //Insert
                                List<String> item = new ArrayList<String>();
                                item.add("12345");
                                item.add("Cristiano Ronaldo");
                                item.add("m");
                                item.add("32");
                                o.insert(item,c1);

                                List<String> item2 = new ArrayList<String>();
                                item2.add("12345");
                                item2.add("Juventus");
                                o.insert(item2,c2);
                                
                                break;
                                
                            case 3:
                                o.delete(100685,c1);
        
                                resultado = o.select(100685, c1);
                                System.out.println(resultado);
                                
                                break;
                                
                            default:
                                System.out.println("\nOperação Invalida. Tente de novo.\n");
                                break;
                        }
                    }
                    while(op2 > 0 && op2 < 4);
                    break;
                    
                case 3:
                    //ETAPA 3 =============================================================================
                    Join j = new Join(c1,c2);
                    j.juncao();
                    break;
                    
                case 4:
                    break;
                    
                default:
                    System.out.println("\nOpção invalida. Tente novamente.\n");
                    break;
            }
        }
        while (op1 > 0 && op1 < 5);        
    }
}
