package bstproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static java.lang.Math.random;

public class TreeControl extends JPanel {
    private BinaryTree<Integer> tree; 
    private JLabel label1 = new JLabel();
    private JLabel label2 = new JLabel();
    private JTextField jtfKey = new JTextField(5);
    private JTextField jtfKey1 = new JTextField(5);
    private JTextField jtfKey2 = new JTextField(5);
    private JLabel labelTree1 = new JLabel();
    private JLabel labelTree2 = new JLabel();
    private JLabel labelTree3 = new JLabel();
    private TreeView TreeView = new TreeView();
    private JButton jbtInsert = new JButton("Insert");
    private JButton jbtDelete = new JButton("Delete");
    private JButton jbtSearch = new JButton("Search");
    private JButton jbtInorder = new JButton("Inorder");
    private JButton jbtPreorder = new JButton("Preorder");
    private JButton jbtPostorder = new JButton("Postorder");
    private JButton jbtClear = new JButton("Clear");

    public TreeControl(BinaryTree<Integer> tree){
        this.tree = tree;
        setUI();
    }

    private void setUI(){
        this.setLayout(new BorderLayout());
        add(TreeView, BorderLayout.CENTER);
        JPanel panelCombine = new JPanel();
        JPanel Pprime = new JPanel();
        JPanel viewPanel = new JPanel();
        JPanel panelKeyAdded = new JPanel();
        JPanel panelKeyDeleted = new JPanel();
        JPanel treeShowPanel = new JPanel();
        label1.setForeground(Color.black);
        label2.setForeground(Color.black);
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        JLabel l1 = new JLabel();
        Font f1;
        Font f2;
        Color c =new Color(100,180,130);
        l1.setText("BINARY SEARCH TREE");
        l1.setHorizontalAlignment(10);
        f1= new Font(Font.MONOSPACED,Font.BOLD,35);
        f2= new Font(Font.MONOSPACED,Font.BOLD,15);
        l1.setForeground(Color.red);
        l1.setFont(f1);
        JPanel p3;JLabel l2;JLabel l3;JLabel l4;JLabel l5;
        p3 = new JPanel();
        Color c2 =new Color(10,210,140);
        
       
        panel.setBackground(Color.black);
        
        panel.add(jtfKey);
        panel.add(jbtInsert);
        panel.add(jtfKey1);
        panel.add(jbtDelete);
        panel.add(jtfKey2);
        panel.add(jbtSearch);
        panel.add(jbtInorder);
        panel.add(jbtPreorder);
        panel.add(jbtPostorder);
        panel.add(jbtClear);
        panel1.setBackground(c2);
        panel1.add(l1);
        panelCombine.add(panel1);
        panelCombine.add(panel);
        
        add(panelCombine, BorderLayout.NORTH); 
        
        label1.setText("Last Node Added: ");
        label1.setFont(f2);
        label2.setText("Last Node Deleted: ");
        label2.setFont(f2);
        
        l2 = new JLabel("Height: ");
        l2.setFont(f2);
        l3 = new JLabel("0  ");
        l3.setFont(f2);
        l4 = new JLabel("Vertices: ");
        l4.setFont(f2);
        l5 = new JLabel("0   ");
        l5.setFont(f2);
        
        labelTree1.setText("Inorder: ");
        labelTree1.setFont(f2);
        labelTree2.setText("Preorder: ");
        labelTree2.setFont(f2);
        labelTree3.setText("Postorder: ");
        labelTree3.setFont(f2);
        
        treeShowPanel.add(labelTree1);
        treeShowPanel.add(labelTree2);
        treeShowPanel.add(labelTree3);
        treeShowPanel.setLayout(new GridLayout(1,3));
        
        p3.add(l2);p3.add(l3);p3.add(l4);p3.add(l5);
        p3.setBackground(c);
        
        panelKeyAdded.add(label1);
        panelKeyDeleted.add(label2);
        
        viewPanel.add(panelKeyAdded);
        viewPanel.add(panelKeyDeleted);
        viewPanel.setLayout(new GridLayout(1,2));
        
        Pprime.add(treeShowPanel);
        Pprime.add(viewPanel);
        Pprime.add(p3);
        Pprime.setLayout(new GridLayout(3,1));
      
        add(Pprime,BorderLayout.SOUTH);
        
        panelCombine.setLayout(new GridLayout(2,1));

        jbtInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                int key = Integer.parseInt(jtfKey.getText());
                
                if(tree.search(key)){
                    JOptionPane.showMessageDialog(null, key +" is already in the tree");
                }
                else{
                    tree.insert(key); // inserting a key
                    TreeView.repaint();
                    String s = ""+tree.getSize();
                    l5.setText(s); // setting the no. of nodes 
                    String s1 =""+ tree.treeHeight(tree.getRoot());
                    l3.setText(s1); // setting the height of the tree
                    label1.setText("Last Node Added: "+key);
                }
                
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null," Please enter an integer number"); // enter a valid number 
                    
                }
                jtfKey.setText("");
            }
        });

        jbtDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                int key = Integer.parseInt(jtfKey1.getText());
                if(!tree.search(key)){
                    JOptionPane.showMessageDialog(null,key+" is not in the tree");
                }
                else{
                    tree.delete(key);
                    TreeView.repaint();
                    String s = ""+tree.getSize();
                    l5.setText(s);
                    String s1 =""+ tree.treeHeight(tree.getRoot());
                    l3.setText(s1);
                    label2.setText("Last Node Deleted: "+key); // last node deleted
                }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null," Please enter an integer number");
                }
                jtfKey1.setText("");
            }
        });
        
        jbtSearch.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                int key = Integer.parseInt(jtfKey2.getText());
                if(!tree.search(key)){
                    JOptionPane.showMessageDialog(null,key+" is not in the tree");
                }
                if(tree.search(key)){
                    JOptionPane.showMessageDialog(null,key+" exists in the tree");
                }
                }catch(Exception ex){
                     JOptionPane.showMessageDialog(null," Please enter an integer number");
                }
                jtfKey2.setText("");
            }
        });
        
        jbtInorder.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                labelTree1.setText("");
                tree.s1="";
               labelTree1.setText("Inorder: "+tree.inorder(tree.root)); // inorder traversal
            }
        });
        
        jbtPostorder.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                labelTree3.setText("");
                tree.s2="";
               labelTree3.setText("Postorder: "+tree.postorder(tree.root)); // postorder traversal
            }
        });
        
        jbtPreorder.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                labelTree2.setText("");
                tree.s3="";
                labelTree2.setText("Preorder: "+tree.preorder(tree.root)); // preorder traversal
            }
        });
        
        jbtClear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                tree.clear();// setting size pf tree =0, and node = null
                TreeView.repaint();
                    // update the labels
                String s = ""+tree.getSize();
                l5.setText(s);
                String s1 =""+ tree.treeHeight(tree.getRoot());
                l3.setText(s1);
                label1.setText("Last Node Added: ");
                label2.setText("Last Node Deleted: ");
                labelTree1.setText("Inorder: ");
                labelTree2.setText("Preorder: ");
                labelTree3.setText("Postorder: ");
            }
        });

    }

    class TreeView extends JPanel{
        private int radius = 20;
        private int vGap = 50;

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            

            if (tree.getRoot() != null){
                displayTree(g, tree.getRoot(), getWidth()/2, 30, getWidth()/12); // display the tree
            }
        }

        private void displayTree(Graphics g, BinaryTree.TreeNode root, int x, int y, int hGap){
            
            g.setColor(Color.red); // node with red color 
            g.fillOval(x-radius, y-radius, 2*radius, 2*radius);

            
            g.setColor(Color.white); // node key with white color
            g.drawString(root.element + "", x-6, y+4);
            
            if (root.left != null)
            {
                connectLeftChild(g, x-hGap, y+vGap,x,y); // logic for left edge
                displayTree(g, root.left,x-hGap, y+vGap, hGap/2);
            }

            if(root.right !=null){
                connectRightChild(g, x+hGap, y+vGap,x,y); // logic for right edge
                displayTree(g, root.right,x+hGap, y+vGap, hGap/2);
            }
        }

        private void connectLeftChild(Graphics g, int x1, int y1, int x2, int y2){
            double d = Math.sqrt(vGap*vGap+(x1-x2)*(x1-x2));
                // setting the coordinates of the edge
            int x11 = (int)((x1 + radius*(x2-x1)/d));
            int y11 = (int)((y1 - radius* vGap/d));
            int x21 = (int)((x2 - radius*(x2-x1)/d));
            int y21 = (int)((y2 + radius* vGap/d));
            g.setColor(Color.black); // edge as black color
            g.drawLine(x11,y11, x21,y21);

        }

        private void connectRightChild(Graphics g, int x1, int y1, int x2, int y2){
            double d = Math.sqrt(vGap*vGap + (x2-x1)*(x2-x1));
                // setting the coordinates of the edge
            int x11 = (int)((x1 - radius*(x1-x2)/d));
            int y11 = (int)((y1 - radius*vGap/d));
            int x21 = (int)((x2 + radius*(x1-x2)/d));
            int y21 = (int)((y2 + radius*vGap/d));
                // edge as black color
            g.setColor(Color.black);
            g.drawLine(x11,y11,x21,y21);

        }
    }
}
