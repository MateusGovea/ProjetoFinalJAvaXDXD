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
        titulo = JOptionPane.showInputDialog("Informe o título: ");
        objetivo = JOptionPane.showInputDialog("Informe o objetivo: ");
        endereco = JOptionPane.showInputDialog("Informe a endereço: ");
        dataInicio = JOptionPane.showInputDialog("Informe a data início: ");
        status = JOptionPane.showInputDialog("Informe o status: ");
		projetoSocial.add("Projeto:");
		projetoSocial.add("\n  Título: " + titulo);
		projetoSocial.add("\n  Objetivo: " + objetivo);
		projetoSocial.add("\n  Endereço: " + endereco);
		projetoSocial.add("\n  Data Início: " + dataInicio);
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
		desc = JOptionPane.showInputDialog("Informe a descrição: ");
		acao = JOptionPane.showInputDialog("Informe a Ação: ");
		projetoSocial.add("\nAgenda:");
		projetoSocial.add("\n  Data: " + data);
		projetoSocial.add("\n  Hora: " + hora);
		projetoSocial.add("\n  Descrição: " + desc);
		projetoSocial.add("\n  Ação: " + acao);
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
