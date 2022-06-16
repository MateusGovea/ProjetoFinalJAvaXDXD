package Trabalho;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Exceptions.ArquivoNaoEncontradoException;
import Trabalho.Arquivo.ManipuladorArquivo;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Consultar extends JFrame {

	private JPanel contentPane;
	private JTextField txtConsulta;

	public Consultar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Consultar");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(192, 58, 123, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblTexto = new JLabel("Digite o nome do arquivo:");
		lblTexto.setBounds(70, 177, 164, 14);
		contentPane.add(lblTexto);
		
		txtConsulta = new JTextField();
		txtConsulta.setBounds(244, 174, 161, 20);
		contentPane.add(txtConsulta);
		txtConsulta.setColumns(10);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setVisible(false);

		btnVoltar.setBounds(208, 237, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnConsulta = new JButton("Consultar");
		
				btnConsulta.setBounds(192, 237, 123, 23);
				contentPane.add(btnConsulta);
		
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				btnConsulta.setVisible(false);
				btnVoltar.setVisible(true);
				String pesquisa = txtConsulta.getText();
				try {
					ManipuladorArquivo.leitor(pesquisa);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Menu().setVisible(true);
				dispose();
			}
		});
	}

}
