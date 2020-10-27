package upload_window;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;

import org.json.JSONArray;
import org.json.JSONObject;

import spgui.SPDialog;
import spgui.componenet.ToggleBtn;
import spgui.componenet.Button;

import java.awt.*;
import java.util.ArrayList;

public class DataTable extends JComponent {

    private static final long serialVersionUID = 1L;
    private SPDialog add_new_data_dialog;
    private int page = 0;
    private JTextField ownerName;
    private JTextField ownerID;
    private JTextField certificateID;
    private JTextField Issuer;
    private JTextField vaild_period;
    private JLabel hasVaildPeriod_txt;
    private ToggleBtn hasVaildPeriod;
    private Button dialog_yes_btn;
    private Button dialog_no_btn;
    Border bottom = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black);
    Border empty = new EmptyBorder(0, 2, 5, 2);
    Border border = new CompoundBorder(bottom, empty);

    ArrayList<JSONObject> data = new ArrayList<>();

    public DataTable() {

    }

    public void addData(JSONObject jsObj) {
        data.add(0, jsObj);
        update();
    }

    public void addData(JSONArray jsArr) {
        for (int i = 0; i < jsArr.length(); i++)
            data.add(jsArr.getJSONObject(i));
        update();
    }

    public void update() {
        this.removeAll();
        int length = (data.size() >= 8) ? 8 : data.size();
        for (int i = 0; i < length; i++) {
            DataTableItem item = new DataTableItem(data.get(i));
            JSONObject myItem = data.get(i);
            item.setBounds(0, this.getComponentCount() * 42, 800, 50);
            item.delete.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    data.remove(myItem);
                    update();
                }
            });
            item.edit.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {

                    /***************************
                     * TextField for ownerName *
                     ***************************/
                    ownerName = new JTextField();
                    ownerName.setText(myItem.getString("ownerName"));
                    ownerName.setForeground(Color.white);
                    ownerName.setBounds(70, 50, 200, 50);
                    ownerName.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 30));
                    // ownerName.addFocusListener(new JTextFieldHintListener(ownerName,
                    // "ownerName"));
                    ownerName.setOpaque(false);
                    ownerName.setBorder(border);
                    ownerName.enableInputMethods(false);
                    ownerName.setFocusable(false);

                    /*************************
                     * TextField for ownerID *
                     *************************/
                    ownerID = new JTextField();
                    ownerID.setText(myItem.getString("ownerID"));
                    ownerID.setForeground(Color.white);
                    ownerID.setBounds(70, 130, 200, 50);
                    ownerID.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 30));
                    // ownerID.addFocusListener(new JTextFieldHintListener(ownerID, "ownerID"));
                    ownerID.setOpaque(false);
                    ownerID.setBorder(border);
                    ownerID.enableInputMethods(false);
                    ownerID.setFocusable(false);

                    /*******************************
                     * TextField for certificateID *
                     *******************************/
                    certificateID = new JTextField();
                    certificateID.setText(myItem.getString("certificateID"));
                    certificateID.setForeground(Color.white);
                    certificateID.setBounds(330, 50, 200, 50);
                    certificateID.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 30));
                    // certificateID.addFocusListener(new JTextFieldHintListener(certificateID,
                    // "certificateID"));
                    certificateID.setOpaque(false);
                    certificateID.setBorder(border);
                    certificateID.enableInputMethods(false);
                    certificateID.setFocusable(false);

                    /************************
                     * TextField for Issuer *
                     ************************/
                    Issuer = new JTextField();
                    Issuer.setText(myItem.getString("issuer"));
                    Issuer.setForeground(Color.white);
                    Issuer.setBounds(330, 130, 200, 50);
                    Issuer.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 30));
                    // Issuer.addFocusListener(new JTextFieldHintListener(Issuer, "Issuer"));
                    Issuer.setOpaque(false);
                    Issuer.setBorder(border);
                    Issuer.enableInputMethods(false);
                    Issuer.setFocusable(false);

                    /******************************
                     * TextField for Vaild period *
                     ******************************/
                    vaild_period = new JTextField();
                    vaild_period.setText(myItem.getString("vaildPeriod"));
                    vaild_period.setForeground(new Color(191, 191, 191));
                    vaild_period.setBounds(330, 210, 200, 50);
                    vaild_period.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 30));
                    // vaild_period.setText("none");
                    vaild_period.setForeground(new Color(191, 191, 191));
                    vaild_period.setOpaque(false);
                    vaild_period.setBorder(border);
                    vaild_period.enableInputMethods(false);
                    vaild_period.setFocusable(false);
                    vaild_period.setEditable(false);

                    hasVaildPeriod_txt = new JLabel("VaildPeriod", null, JLabel.CENTER);
                    hasVaildPeriod_txt.setBounds(25, 210, 200, 50);
                    hasVaildPeriod_txt.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
                    hasVaildPeriod_txt.setForeground(Color.WHITE);

                    add_new_data_dialog = new SPDialog(600, 450);
                    add_new_data_dialog.setLocationRelativeTo(null);
                    add_new_data_dialog.setTitle("修改資料");
                    add_new_data_dialog.setTitleBarColor(new Color(10, 10, 10, 250));
                    add_new_data_dialog.setBackgroundColor(new Color(120, 120, 120, 255));
                    hasVaildPeriod = new ToggleBtn(50, 30);
                    hasVaildPeriod.setBounds(180, 205, 200, 150);
                    hasVaildPeriod.setColor(new Color(255, 44, 140, 200), new Color(255, 44, 140, 255),
                            new Color(255, 44, 140, 100));

                    isFocusable(ownerName);
                    isFocusable(ownerID);
                    isFocusable(certificateID);
                    isFocusable(Issuer);

                    dialog_yes_btn = new Button(120, 50, 32, null, new Color(255, 255, 255, 255), "修改", 48, true);
                    dialog_yes_btn.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
                    dialog_yes_btn.setBounds(370, 340, 140, 70);
                    dialog_yes_btn.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            add_new_data_dialog.setVisible(false);
                            ownerName.setFocusable(false);
                            ownerID.setFocusable(false);
                            certificateID.setFocusable(false);
                            Issuer.setFocusable(false);
                            vaild_period.setFocusable(false);

                            myItem.put("ownerName", ownerName.getText());
                            myItem.put("ownerID", ownerID.getText());
                            myItem.put("certificateID", certificateID.getText());
                            myItem.put("issuer", Issuer.getText());
                            myItem.put("vaildPeriod", vaild_period.getText());
                            item.setDataView(myItem);

                            ownerName.setText("");
                            ownerName.addFocusListener(new JTextFieldHintListener(ownerName, "ownerName"));
                            ownerID.setText("");
                            ownerID.addFocusListener(new JTextFieldHintListener(ownerID, "ownerID"));
                            certificateID.setText("");
                            certificateID.addFocusListener(new JTextFieldHintListener(certificateID, "certificateID"));
                            Issuer.setText("");
                            Issuer.addFocusListener(new JTextFieldHintListener(Issuer, "Issuer"));
                            vaild_period.setText("none");
                            vaild_period.setEditable(false);
                            vaild_period.setFocusable(false);
                        }
                    });
                    dialog_no_btn = new Button(120, 50, 32, null, new Color(255, 255, 255, 255), "取消", 48, true);
                    dialog_no_btn.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
                    dialog_no_btn.setBounds(110, 340, 140, 70);
                    dialog_no_btn.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            add_new_data_dialog.setVisible(false);
                            ownerName.setFocusable(false);
                            ownerID.setFocusable(false);
                            certificateID.setFocusable(false);
                            Issuer.setFocusable(false);
                            vaild_period.setFocusable(false);
                        }
                    });
                    hasVaildPeriod.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            boolean status = hasVaildPeriod.getStatus();
                            if (status) {
                                vaild_period.setFocusable(false);
                                vaild_period.setEditable(false);
                                vaild_period.setText("none");
                                vaild_period.setForeground(new Color(191, 191, 191));
                            } else {
                                vaild_period.setFocusable(true);
                                vaild_period.setEditable(true);
                                vaild_period.addFocusListener(new JTextFieldHintListener(vaild_period, "vaild_period"));
                            }
                            ownerName.setFocusable(false);
                            ownerID.setFocusable(false);
                            certificateID.setFocusable(false);
                            Issuer.setFocusable(false);
                        }
                    });
                    add_new_data_dialog.addi(ownerName);
                    add_new_data_dialog.addi(ownerID);
                    add_new_data_dialog.addi(certificateID);
                    add_new_data_dialog.addi(Issuer);
                    add_new_data_dialog.addi(vaild_period);
                    add_new_data_dialog.addi(dialog_yes_btn);
                    add_new_data_dialog.addi(dialog_no_btn);
                    add_new_data_dialog.addi(hasVaildPeriod);
                    add_new_data_dialog.addi(hasVaildPeriod_txt);
                    dialog_yes_btn.setVisible(true);
                    dialog_no_btn.setVisible(true);
                    add_new_data_dialog.setVisible(true);

                    // System.out.println(data);
                }
            });
            add(item);
        }
        this.repaint();
    }

    public int changPage(int page) {
        this.removeAll();
        this.page = page <= 0 ? 0 : page;
        this.page = this.page >= (data.size() / 8) ? (data.size() / 8) : this.page;
        this.page = data.size() % 8 == 0 ? this.page - 1 : this.page;
        int temp = 8 * this.page;
        for (int i = temp; i < temp + 8 && i < data.size(); i++) {
            JSONObject myItem = data.get(i);
            DataTableItem item = new DataTableItem(data.get(i));
            item.setBounds(0, this.getComponentCount() * 42, 800, 50);
            item.delete.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    data.remove(myItem);
                    changPage(getPage());
                }
            });
            item.edit.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {

                    /***************************
                     * TextField for ownerName *
                     ***************************/
                    ownerName = new JTextField();
                    ownerName.setText(myItem.getString("ownerName"));
                    ownerName.setForeground(Color.white);
                    ownerName.setBounds(70, 50, 200, 50);
                    ownerName.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 30));
                    // ownerName.addFocusListener(new JTextFieldHintListener(ownerName,
                    // "ownerName"));
                    ownerName.setOpaque(false);
                    ownerName.setBorder(border);
                    ownerName.enableInputMethods(false);
                    ownerName.setFocusable(false);

                    /*************************
                     * TextField for ownerID *
                     *************************/
                    ownerID = new JTextField();
                    ownerID.setText(myItem.getString("ownerID"));
                    ownerID.setForeground(Color.white);
                    ownerID.setBounds(70, 130, 200, 50);
                    ownerID.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 30));
                    // ownerID.addFocusListener(new JTextFieldHintListener(ownerID, "ownerID"));
                    ownerID.setOpaque(false);
                    ownerID.setBorder(border);
                    ownerID.enableInputMethods(false);
                    ownerID.setFocusable(false);

                    /*******************************
                     * TextField for certificateID *
                     *******************************/
                    certificateID = new JTextField();
                    certificateID.setText(myItem.getString("certificateID"));
                    certificateID.setForeground(Color.white);
                    certificateID.setBounds(330, 50, 200, 50);
                    certificateID.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 30));
                    // certificateID.addFocusListener(new JTextFieldHintListener(certificateID,
                    // "certificateID"));
                    certificateID.setOpaque(false);
                    certificateID.setBorder(border);
                    certificateID.enableInputMethods(false);
                    certificateID.setFocusable(false);

                    /************************
                     * TextField for Issuer *
                     ************************/
                    Issuer = new JTextField();
                    Issuer.setText(myItem.getString("issuer"));
                    Issuer.setForeground(Color.white);
                    Issuer.setBounds(330, 130, 200, 50);
                    Issuer.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 30));
                    // Issuer.addFocusListener(new JTextFieldHintListener(Issuer, "Issuer"));
                    Issuer.setOpaque(false);
                    Issuer.setBorder(border);
                    Issuer.enableInputMethods(false);
                    Issuer.setFocusable(false);

                    /******************************
                     * TextField for Vaild period *
                     ******************************/
                    vaild_period = new JTextField();
                    vaild_period.setText(myItem.getString("vaildPeriod"));
                    vaild_period.setForeground(new Color(191, 191, 191));
                    vaild_period.setBounds(330, 210, 200, 50);
                    vaild_period.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 30));
                    // vaild_period.setText("none");
                    vaild_period.setForeground(new Color(191, 191, 191));
                    vaild_period.setOpaque(false);
                    vaild_period.setBorder(border);
                    vaild_period.enableInputMethods(false);
                    vaild_period.setFocusable(false);
                    vaild_period.setEditable(false);

                    hasVaildPeriod_txt = new JLabel("VaildPeriod", null, JLabel.CENTER);
                    hasVaildPeriod_txt.setBounds(25, 210, 200, 50);
                    hasVaildPeriod_txt.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
                    hasVaildPeriod_txt.setForeground(Color.WHITE);

                    add_new_data_dialog = new SPDialog(600, 450);
                    add_new_data_dialog.setTitle("修改資料");
                    add_new_data_dialog.setTitleBarColor(new Color(10, 10, 10, 250));
                    add_new_data_dialog.setBackgroundColor(new Color(120, 120, 120, 255));
                    hasVaildPeriod = new ToggleBtn(50, 30);
                    hasVaildPeriod.setBounds(180, 205, 200, 150);
                    hasVaildPeriod.setColor(new Color(255, 44, 140, 200), new Color(255, 44, 140, 255),
                            new Color(255, 44, 140, 100));

                    isFocusable(ownerName);
                    isFocusable(ownerID);
                    isFocusable(certificateID);
                    isFocusable(Issuer);

                    dialog_yes_btn = new Button(120, 50, 32, null, new Color(255, 255, 255, 255), "修改", 48, true);
                    dialog_yes_btn.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
                    dialog_yes_btn.setBounds(370, 340, 140, 70);
                    dialog_yes_btn.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            add_new_data_dialog.setVisible(false);
                            ownerName.setFocusable(false);
                            ownerID.setFocusable(false);
                            certificateID.setFocusable(false);
                            Issuer.setFocusable(false);
                            vaild_period.setFocusable(false);

                            myItem.put("ownerName", ownerName.getText());
                            myItem.put("ownerID", ownerID.getText());
                            myItem.put("certificateID", certificateID.getText());
                            myItem.put("issuer", Issuer.getText());
                            myItem.put("vaildPeriod", vaild_period.getText());
                            item.setDataView(myItem);

                            ownerName.setText("");
                            ownerName.addFocusListener(new JTextFieldHintListener(ownerName, "ownerName"));
                            ownerID.setText("");
                            ownerID.addFocusListener(new JTextFieldHintListener(ownerID, "ownerID"));
                            certificateID.setText("");
                            certificateID.addFocusListener(new JTextFieldHintListener(certificateID, "certificateID"));
                            Issuer.setText("");
                            Issuer.addFocusListener(new JTextFieldHintListener(Issuer, "Issuer"));
                            vaild_period.setText("none");
                            vaild_period.setEditable(false);
                            vaild_period.setFocusable(false);
                        }
                    });
                    dialog_no_btn = new Button(120, 50, 32, null, new Color(255, 255, 255, 255), "取消", 48, true);
                    dialog_no_btn.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
                    dialog_no_btn.setBounds(110, 340, 140, 70);
                    dialog_no_btn.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            add_new_data_dialog.setVisible(false);
                            ownerName.setFocusable(false);
                            ownerID.setFocusable(false);
                            certificateID.setFocusable(false);
                            Issuer.setFocusable(false);
                            vaild_period.setFocusable(false);
                        }
                    });
                    hasVaildPeriod.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            boolean status = hasVaildPeriod.getStatus();
                            if (status) {
                                vaild_period.setFocusable(false);
                                vaild_period.setEditable(false);
                                vaild_period.setText("none");
                                vaild_period.setForeground(new Color(191, 191, 191));
                            } else {
                                vaild_period.setFocusable(true);
                                vaild_period.setEditable(true);
                                vaild_period.addFocusListener(new JTextFieldHintListener(vaild_period, "vaild_period"));
                            }
                            ownerName.setFocusable(false);
                            ownerID.setFocusable(false);
                            certificateID.setFocusable(false);
                            Issuer.setFocusable(false);
                        }
                    });
                    add_new_data_dialog.addi(ownerName);
                    add_new_data_dialog.addi(ownerID);
                    add_new_data_dialog.addi(certificateID);
                    add_new_data_dialog.addi(Issuer);
                    add_new_data_dialog.addi(vaild_period);
                    add_new_data_dialog.addi(dialog_yes_btn);
                    add_new_data_dialog.addi(dialog_no_btn);
                    add_new_data_dialog.addi(hasVaildPeriod);
                    add_new_data_dialog.addi(hasVaildPeriod_txt);
                    dialog_yes_btn.setVisible(true);
                    dialog_no_btn.setVisible(true);
                    add_new_data_dialog.setVisible(true);

                    // System.out.println(data);
                }
            });
            add(item);
        }

        this.repaint();
        return this.page;
    }

    protected void isFocusable(JTextField textField) {
        textField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                textField.setFocusable(true);
            }
        });
    }

    public int getPage() {
        System.out.println(page);
        return this.page;
    }

    public ArrayList<JSONObject> getData() {
        return this.data;
    }
}

class DataTableItem extends JComponent {

    private static final long serialVersionUID = 1L;

    private ImageIcon edit_img = new ImageIcon(getClass().getResource("/upload_window/res/edit.png"));
    private ImageIcon edit_big_img = new ImageIcon(getClass().getResource("/upload_window/res/edit_big.png"));
    private ImageIcon delete_img = new ImageIcon(getClass().getResource("/upload_window/res/delete.png"));
    private ImageIcon delete_big_img = new ImageIcon(getClass().getResource("/upload_window/res/delete_big.png"));

    private JLabel ownerName = new JLabel();
    private JLabel ownerID = new JLabel();
    private JLabel certificateID = new JLabel();
    private JLabel issuer = new JLabel();
    private JLabel vaildPeriod = new JLabel();
    public JLabel edit = new JLabel(edit_img);
    public JLabel delete = new JLabel(delete_img);

    public DataTableItem(JSONObject data_info) {
        ownerName.setForeground(Color.WHITE);
        ownerName.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
        ownerName.setText(data_info.getString("ownerName"));
        ownerName.setBounds(15, 0, 200, 50);
        add(ownerName);

        ownerID.setForeground(Color.WHITE);
        ownerID.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
        ownerID.setText(data_info.getString("ownerID"));
        ownerID.setBounds(138, 0, 200, 50);
        add(ownerID);

        certificateID.setForeground(Color.WHITE);
        certificateID.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
        certificateID.setText(data_info.getString("certificateID"));
        certificateID.setBounds(260, 0, 200, 50);
        add(certificateID);

        issuer.setForeground(Color.WHITE);
        issuer.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
        issuer.setText(data_info.getString("issuer"));
        issuer.setBounds(405, 0, 200, 50);
        add(issuer);

        vaildPeriod.setForeground(Color.WHITE);
        vaildPeriod.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
        vaildPeriod.setText(data_info.getString("vaildPeriod"));
        vaildPeriod.setBounds(543, 0, 200, 50);
        add(vaildPeriod);

        edit.setBounds(655, 14, 18, 18);
        edit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                edit.setIcon(edit_big_img);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                edit.setIcon(edit_img);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                edit.setIcon(edit_img);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                edit.setIcon(edit_big_img);
            }

            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
        add(edit);

        delete.setBounds(690, 14, 18, 18);
        delete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                delete.setIcon(delete_big_img);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                delete.setIcon(delete_img);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                delete.setIcon(delete_img);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                delete.setIcon(delete_big_img);
            }

            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
        add(delete);
    }

    public void setDataView(JSONObject data_info) {
        ownerName.setText(data_info.getString("ownerName"));
        ownerID.setText(data_info.getString("ownerID"));
        certificateID.setText(data_info.getString("certificateID"));
        issuer.setText(data_info.getString("issuer"));
        vaildPeriod.setText(data_info.getString("vaildPeriod"));
        repaint();
    }
}
