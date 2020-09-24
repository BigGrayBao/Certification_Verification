package upload_window;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import jiconfont.icons.font_awesome.FontAwesome;

import java.awt.*;
import java.awt.event.*;
import java.awt.Color;

import java.util.ArrayList;

import spgui.SPDialog;
import spgui.SPWindow;
import spgui.componenet.Button;
import spgui.componenet.ToggleBtn;
import spgui.componenet.UploadArea;

public class GUI {
    SPWindow window = new SPWindow(800, 600);

    Border bottom = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black);
    Border empty = new EmptyBorder(0, 2, 5, 2);
    Border border = new CompoundBorder(bottom, empty);

    private JTextField ownerName;
    private JTextField ownerID;
    private JTextField certificateID;
    private JTextField Issuer;
    private JTextField vaild_period;

    private JLabel open_vaild_period_txt;
    private JLabel dialog_txt;
    private JLabel dialog_txt2;

    private ToggleBtn vaild_period_btn;
    private Button dialog_yes_btn;
    private Button dialog_no_btn;
    private Button upload_btn;

    private SPDialog dialog;
    private UploadCertification upload;
    private UploadArea uploadArea;

    private ImageIcon tittlebar_icon = new ImageIcon(getClass().getResource("/upload_window/res/BigGrayBao.png"));
    // private ImageIcon upload_btn_icon = new
    // ImageIcon(getClass().getResource("/upload_window/res/bao.png"));

    private ArrayList<String> certification = new ArrayList<>();

    public void show() {
        window.repaint();
        window.windowContent.repaint();
        window.setVisible(true);
    }

    public void run() {
        window.setVisible(false);
        window.setBackgroundColor(new Color(255, 255, 255, 255));
        window.setLocationRelativeTo(null);
        window.setTitleBarColor(new Color(255, 44, 140, 220));
        window.setResizable(false);
        window.setTitle("BaoGrayBao");
        window.setIcon(tittlebar_icon.getImage());

        open_vaild_period_txt = new JLabel();
        open_vaild_period_txt.setText("open Vaild Period");
        open_vaild_period_txt.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
        open_vaild_period_txt.setBounds(450, 243, 150, 100);
        open_vaild_period_txt.setVisible(true);
        window.addi(open_vaild_period_txt);

        /******************************************
         * A toggle button to enable vaild preiod *
         ******************************************/
        vaild_period_btn = new ToggleBtn(50, 30);
        vaild_period_btn.setBounds(615, 260, 150, 100);
        vaild_period_btn.setColor(new Color(255, 44, 140, 200), new Color(255, 44, 140, 255),
                new Color(255, 44, 140, 100));
        vaild_period_btn.setVisible(true);
        window.addi(vaild_period_btn);
        vaild_period_btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                boolean status = !vaild_period_btn.getStatus();
                vaild_period.setVisible(status);
            }
        });

        /***************************
         * TextField for ownerName *
         ***************************/
        ownerName = new JTextField();
        ownerName.setBounds(100, 70, 250, 50);
        ownerName.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 30));
        ownerName.addFocusListener(new JTextFieldHintListener(ownerName, "ownerName"));
        ownerName.setOpaque(false);
        ownerName.setBorder(border);
        ownerName.enableInputMethods(false);
        window.addi(ownerName);

        /*************************
         * TextField for ownerID *
         *************************/
        ownerID = new JTextField();
        ownerID.setBounds(100, 170, 250, 50);
        ownerID.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 30));
        ownerID.addFocusListener(new JTextFieldHintListener(ownerID, "ownerID"));
        ownerID.setOpaque(false);
        ownerID.setBorder(border);
        ownerID.enableInputMethods(false);
        window.addi(ownerID);

        /*******************************
         * TextField for certificateID *
         *******************************/
        certificateID = new JTextField();
        certificateID.setBounds(450, 70, 250, 50);
        certificateID.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 30));
        certificateID.addFocusListener(new JTextFieldHintListener(certificateID, "certificateID"));
        certificateID.setOpaque(false);
        certificateID.setBorder(border);
        certificateID.enableInputMethods(false);
        window.addi(certificateID);

        /************************
         * TextField for Issuer *
         ************************/
        Issuer = new JTextField();
        Issuer.setBounds(450, 170, 250, 50);
        Issuer.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 30));
        Issuer.addFocusListener(new JTextFieldHintListener(Issuer, "Issuer"));
        Issuer.setOpaque(false);
        Issuer.setBorder(border);
        Issuer.enableInputMethods(false);
        window.addi(Issuer);

        /******************************
         * TextField for Vaild period *
         ******************************/
        vaild_period = new JTextField();
        vaild_period.setBounds(100, 270, 250, 50);
        vaild_period.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 30));
        vaild_period.addFocusListener(new JTextFieldHintListener(vaild_period, "Vaild period"));
        vaild_period.setOpaque(false);
        vaild_period.setBorder(border);
        vaild_period.setVisible(false);
        vaild_period.enableInputMethods(false);
        window.addi(vaild_period);

        /****************************
         * A uploadArea to add file *
         ****************************/
        uploadArea = new UploadArea();
        uploadArea.setBounds(150, 360, 450, 450);
        window.addi(uploadArea);

        /************************************
         * A button to upload certification *
         ************************************/
        upload_btn = new Button(50, FontAwesome.UPLOAD, new Color(240, 50, 150), "Upload");
        upload_btn.setBounds(450, 380, 500, 500);
        upload_btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                upload = new UploadCertification();
                upload.setCertification(certification);
                upload.printCertification();

                dialog = new SPDialog(350, 200);
                dialog.setTitle("Bao");
                dialog.setIcon(tittlebar_icon.getImage());
                dialog.setLocationRelativeTo(window);
                dialog.setBackgroundColor(new Color(255, 44, 140, 240));

                dialog_yes_btn = new Button(20, FontAwesome.CHECK_CIRCLE, new Color(255, 255, 255), "Yes");
                dialog_yes_btn.setBounds(60, 110, 100, 40);
                dialog_yes_btn.setVisible(true);
                dialog_yes_btn.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        System.out.println("Yes");
                        dialog.setVisible(false);
                    }
                });
                dialog_no_btn = new Button(20, FontAwesome.TIMES_CIRCLE, new Color(255, 255, 255), " No ");
                dialog_no_btn.setBounds(200, 110, 100, 40);
                dialog_no_btn.setVisible(true);
                dialog_no_btn.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        System.out.println("No");
                        dialog.setVisible(false);
                    }
                });
                dialog_txt = new JLabel("You can not modify after upload.");
                dialog_txt2 = new JLabel("Do you want to upload?");
                dialog_txt.setBounds(35, 30, 400, 30);
                dialog_txt2.setBounds(70, 55, 400, 30);
                dialog_txt.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
                dialog_txt2.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
                dialog_txt.setVisible(true);
                dialog_txt2.setVisible(true);

                dialog.addi(dialog_yes_btn);
                dialog.addi(dialog_no_btn);
                dialog.addi(dialog_txt);
                dialog.addi(dialog_txt2);
                dialog.setVisible(true);
            }
        });
        window.addi(upload_btn);
    }
}
