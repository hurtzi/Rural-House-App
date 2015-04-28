package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import domain.RuralHouse;
import domain.Comment;

import java.awt.Font;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

public class CommentPanelOwner extends JPanel {

	/**
	 * Create the panel.
	 */
	public CommentPanelOwner(LinkedList<Comment> commentList, int ind) {
		setLayout(null);
		

		JLabel lblOwner = new JLabel("Data:");
		lblOwner.setBounds(123, 11, 46, 14);
		add(lblOwner);
		
		JLabel searchDate = new JLabel("");
		searchDate.setBounds(156, 11, 138, 14);
		add(searchDate);
		SimpleDateFormat sf = new SimpleDateFormat("dd-MM-YYYY"); 
        DateFormat formatoHora = new SimpleDateFormat("HH:mm");
        searchDate.setText(sf.format(commentList.get(ind).getEguna()) +"  "+ formatoHora.format(commentList.get(ind).getEguna()) );
        
        


	
		JLabel lblEgilea = new JLabel("Egilea:");
		lblEgilea.setBounds(10, 11, 38, 14);
		add(lblEgilea);
		
		JLabel searchEgilea = new JLabel("");
		searchEgilea.setBounds(49, 11, 85, 14);
		add(searchEgilea);
		searchEgilea.setText(commentList.get(ind).getEgilea().getLogin() );

		JLabel lblVote = new JLabel("Vote:");
		lblVote.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVote.setBounds(305, 11, 38, 14);
		add(lblVote);
		
		JLabel searchVote = new JLabel("");
		searchVote.setFont(new Font("Tahoma", Font.BOLD, 11));
		searchVote.setBounds(341, 11, 32, 14);
		add(searchVote);
		Integer Nota = commentList.get(ind).getBotua(); 
		if(Nota>=8){
			searchVote.setForeground(Color.GREEN);
		}else if(Nota>=5 && Nota<8){
			searchVote.setForeground(Color.BLUE);
		}else if(Nota>=3 && Nota<5){
			searchVote.setForeground(Color.YELLOW);
		}else if(Nota>=0 && Nota<3){
			searchVote.setForeground(Color.RED);
		}
		searchVote.setText(Integer.toString(Nota));
	
		
		
		JLabel lblComment = new JLabel("Comment:");
		lblComment.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblComment.setBounds(10, 36, 85, 14);
		add(lblComment);

		JLabel searchComment = new JLabel("");
		searchComment.setBounds(20, 52, 513, 26);
		add(searchComment);
		searchComment.setBackground(Color.WHITE);
		searchComment.setText(commentList.get(ind).getComent());
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				commentList.remove(ind);
				//-+--+-+-+-+-+-+-+---+-++-+----+-+-++-+-+-+-+-+--+-+--+-+-+--+-+-+-+-+-+-+++-+--+--+-+-+-+--+-+-+-+datu basean gorde
			}
		});
		btnDelete.setForeground(Color.RED);
		btnDelete.setBounds(444, 7, 89, 23);
		add(btnDelete);
		
		
		
		

	}
}
