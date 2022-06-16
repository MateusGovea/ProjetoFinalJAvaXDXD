package Trabalho;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Projeto Final");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(177, 58, 162, 35);
		contentPane.add(lblNewLabel);
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Criar().setVisible(true);
				dispose();
			}
		});
		btnCriar.setBounds(203, 156, 102, 28);
		contentPane.add(btnCriar);
		
		JButton btnCarregar = new JButton("Carregar");
		btnCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Consultar().setVisible(true);
				dispose();
			}
		});
		btnCarregar.setBounds(203, 258, 102, 28);
		contentPane.add(btnCarregar);
		
		JButton btnEditar = new JButton("Adicionar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Editar().setVisible(true);
				dispose();
			}
		});
		btnEditar.setBounds(203, 204, 102, 28);
		contentPane.add(btnEditar);
	}
}
