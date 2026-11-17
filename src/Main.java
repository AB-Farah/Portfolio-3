import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Graph g = new MatrixGraph(27);
        GraphAlgorithms.readGraph(g, "combi.txt");

//---------------------------------------------------//

        Vertex v = g.vertex("DATA");
        Collection<Vertex> visited
                = GraphAlgorithms.visitBreadthFirst(g, v);
        System.out.println("visited " + visited);


        if (visited.size() == g.vertices().size()) {
            System.out.println("The graph is connected");
        } else {
            System.out.println("The graph is not connected");

        }
//------------------------------------------------------//

        List<String> lst = new ArrayList<>();
        for (Vertex w : g.vertices()) {
            String combi = "" + g.outEdge(w).size();
            if (combi.length() == 1) combi = " " + combi;
            lst.add(combi + " " + w);
        }
        Collections.sort(lst);
        for (String line : lst) {
            System.out.println(line);
        }
//-----------------------------------------//

        List<List<String>> grps = List.of(
                List.of("IS", "KEMI", "PSYK"),
                List.of("HIST", "PLANBY"),
                List.of("VIRK"),
                List.of("JOURNALIST", "PÆD"),
                List.of("ENG", "GEO", "MAT", "SUNDHFR"),
                List.of("PA", "PERF"),
                List.of("FYSIK", "INFORMATIK", "KULTUR", "MOLBIO"),
                List.of("ARBLIV"),
                List.of("DANSK", "TEKSAM"),
                List.of("DATA", "MEDBIO", "SOC"),
                List.of("FILO"),
                List.of("KOMM", "MILBIO"));

        boolean feasible = true;

        for (List<String> grp : grps) {
            for (String s : grp) for (String t : grp) {
                    Integer w = g.getWeight(g.vertex(s), g.vertex(t));
                    if (w != null) {
                        System.out.println("Not feasible " + s + " " + t);
                        feasible = false;
               }
            }
        }

        if (feasible) {
            System.out.println("Valid solution");
        } else {
            System.out.println("Not valid solution");
        }


//--------------------------------------//
   int numadjcent =0;

    for (int i = 1; i < grps.size(); i++) {
    List<String> grp1 = grps.get(i - 1);
    List<String> grp2 = grps.get(i);

    for (String s:grp1) for (String t:grp2){
        Integer w = g.getWeight(g.vertex(s), g.vertex(t));
        if (w!=null)numadjcent +=w;
        }
    }
    System.out.println("numadjcent " + numadjcent);


    int numadjcent2 = 0;
    List<List<String>> shuffled = new ArrayList<>(grps);
    Collections.shuffle(shuffled);
    System.out.println(shuffled);
    for (int i = 1; i <shuffled.size(); i++){
        List<String> grp1 = shuffled.get(i - 1);
        List<String> grp2 = shuffled.get(i);
        System.out.println("Compare" + grp1+ " " + grp2);

    for (String s:grp1) for (String t:grp2){
        Integer w = g.getWeight(g.vertex(s), g.vertex(t));
        if (w!=null)numadjcent2 +=w;
      }
    }
    System.out.println("numadjcent2 " + numadjcent2);
  }
}