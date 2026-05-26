import java.io.*;
import java.util.HashMap;

public class GravadorDeDados {

    public void salvarDados(HashMap<String, Filme> filmes)
            throws IOException {

        ObjectOutputStream out =
                new ObjectOutputStream(
                        new FileOutputStream("filmes.dat"));

        out.writeObject(filmes);

        out.close();
    }

    public HashMap<String, Filme> recuperarDados()
            throws IOException, ClassNotFoundException {

        ObjectInputStream in =
                new ObjectInputStream(
                        new FileInputStream("filmes.dat"));

        HashMap<String, Filme> filmes =
                (HashMap<String, Filme>) in.readObject();

        in.close();

        return filmes;
    }
}
