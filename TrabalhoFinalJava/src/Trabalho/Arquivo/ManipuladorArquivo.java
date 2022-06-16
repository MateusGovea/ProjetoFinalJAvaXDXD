package Trabalho.Arquivo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ManipuladorArquivo {
	public static void leitor(String path) throws IOException {

		BufferedReader leitor = new BufferedReader(new FileReader(path));
		String projetoSocial = "", dados = "";
		while (true) {
			if (projetoSocial != null) {
				dados += "\n" + projetoSocial;
			} else
				break;
			projetoSocial = leitor.readLine();
		}
		JOptionPane.showMessageDialog(null, dados);
		leitor.close();
	}

	public static void escritor(String path) throws IOException {

		String linha = "";
        String titulo = "", objetivo = "", endereco = "", dataInicio = "", status = "";
        ArrayList<String> projetoSocial = new ArrayList();
        JOptionPane.showMessageDialog(null, "Digite os dados do projeto:");
        titulo = JOptionPane.showInputDialog("Informe o t�tulo: ");
        objetivo = JOptionPane.showInputDialog("Informe o objetivo: ");
        endereco = JOptionPane.showInputDialog("Informe a endere�o: ");
        dataInicio = JOptionPane.showInputDialog("Informe a data in�cio: ");
        status = JOptionPane.showInputDialog("Informe o status: ");
		projetoSocial.add("Projeto:");
		projetoSocial.add("\n  T�tulo: " + titulo);
		projetoSocial.add("\n  Objetivo: " + objetivo);
		projetoSocial.add("\n  Endere�o: " + endereco);
		projetoSocial.add("\n  Data In�cio: " + dataInicio);
		projetoSocial.add("\n  Status: " + status);
		escreverArquivo(path, projetoSocial);
		escritorAgenda(path);
	}
	
	public static void escritorAgenda(String path) throws IOException {
	    
		String linha = "";
        String data = "", hora = "", desc = "", acao = "";
        ArrayList<String> projetoSocial = new ArrayList();
        JOptionPane.showMessageDialog(null, "Digite uma nova agenda:");
		data = JOptionPane.showInputDialog("Informe a data:");
		hora = JOptionPane.showInputDialog("Informe a hora: ");
		desc = JOptionPane.showInputDialog("Informe a descri��o: ");
		acao = JOptionPane.showInputDialog("Informe a A��o: ");
		projetoSocial.add("\nAgenda:");
		projetoSocial.add("\n  Data: " + data);
		projetoSocial.add("\n  Hora: " + hora);
		projetoSocial.add("\n  Descri��o: " + desc);
		projetoSocial.add("\n  A��o: " + acao);
        escreverArquivo(path, projetoSocial);
	}
	
	public static void escreverArquivo(String file, ArrayList<String> resposta) throws IOException {
			boolean anexar = false;
			File f = new File(file);
			if (f.length() != 0L)
				anexar = true;
			FileWriter writer = new FileWriter(new File(file), anexar);
			BufferedWriter bufferedWriter = new BufferedWriter(writer);

			for (int i = 0; i < resposta.size(); i++) {
				bufferedWriter.write(resposta.get(i));
			}
			bufferedWriter.flush();
			writer.close();
			bufferedWriter.close();
			}
}
