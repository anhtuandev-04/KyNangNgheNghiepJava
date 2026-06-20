package BaiTapGUIb4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Bai22 extends JFrame {
    private JLabel lblQuestion, lblFeedback;
    private JTextField txtAnswer;
    private JButton btnOK, btnNext;
    
    private int num1, num2, correctAnswer;
    private int correctCount = 0;
    private int totalCount = 0;
    private Random random = new Random();

    public Bai22() {
        
        setTitle("Teach Arithmetic");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        
        lblQuestion = new JLabel("");
        lblQuestion.setFont(new Font("Arial", Font.BOLD, 18));
        
        txtAnswer = new JTextField(10);
        
        btnOK = new JButton("OK");
        btnNext = new JButton("Next");
        
        lblFeedback = new JLabel("Hãy nhập câu trả lời!");
        lblFeedback.setForeground(Color.BLUE);

        
        generateNewProblem();

        
        ActionListener checkAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkUserAnswer();
            }
        };
        btnOK.addActionListener(checkAction);
        txtAnswer.addActionListener(checkAction);        
        btnNext.addActionListener(e -> {
            generateNewProblem();
        });

    
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                String summary = "Tổng kết:\n" + 
                                 "Số câu trả lời đúng: " + correctCount + "\n" +
                                 "Tổng số câu đã làm: " + totalCount;
                JOptionPane.showMessageDialog(null, summary, "Kết thúc", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        });

        
        add(lblQuestion);
        add(txtAnswer);
        add(btnOK);
        add(btnNext);
        add(lblFeedback);
    }

    // Hàm tạo bài toán mới (phạm vi 2 chữ số: 10-99)
    private void generateNewProblem() {
        num1 = random.nextInt(90) + 10; 
        num2 = random.nextInt(90) + 10;
        correctAnswer = num1 + num2;
        
        lblQuestion.setText("Bao nhiêu là: " + num1 + " + " + num2 + " ?");
        lblFeedback.setText("Hãy nhập câu trả lời!");
        lblFeedback.setForeground(Color.BLUE);
        txtAnswer.setText("");
        txtAnswer.requestFocus(); 
    }

    private void checkUserAnswer() {
        try {
            int userAnswer = Integer.parseInt(txtAnswer.getText());
            totalCount++;
            
            if (userAnswer == correctAnswer) {
                lblFeedback.setText("Câu trả lời đúng!!!");
                lblFeedback.setForeground(new Color(0, 153, 51)); // Màu xanh lá
                correctCount++;
            } else {
                lblFeedback.setText("Trả lời sai! Đáp án là " + correctAnswer);
                lblFeedback.setForeground(Color.RED);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng chỉ nhập số!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Bai22().setVisible(true);
        });
    }
}