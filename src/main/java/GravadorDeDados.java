import java.io.*;
import java.util.HashMap;

public class GravadorDeDados {

    public void salvarDados(HashMap<String, Filme> filmes) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("filmes.dat"));
        out.writeObject(filmes);
        out.close();
    }

    @SuppressWarnings("unchecked")
    public HashMap<String, Filme> recuperarDados() throws IOException, ClassNotFoundException {
        File arquivo = new File("filmes.dat");
        if (!arquivo.exists()) {
            return new HashMap<>(); // Retorna um Map vazio se o arquivo não existir ainda
        }

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(arquivo));
        HashMap<String, Filme> filmes = (HashMap<String, Filme>) in.readObject();
        in.close();

        return filmes;
    }
}
