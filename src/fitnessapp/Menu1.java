package fitnessapp;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class Menu1 extends JComponent {

    private MigLayout layout;
    private String[][] menuItems = new String[][]{
        {"WorkOut A", "Body Weight Squats", "Pull Ups", "Mountain Climber"},
        {"WorkOut B", "Push Ups", "Dips", "Chin Ups"},
    };

    public Menu1() {
        init();
    }

    private void init() {
        layout = new MigLayout("Wrap 1, fillx, gapy 0, inset 2", "fill");
        setLayout(layout);

        for (int i = 0; i < menuItems.length; i++) {
            addMenu(menuItems[i][0], i);
        }
    }

    private Icon getIcon(String menuName) {
        URL url = getClass().getResource("/images/down.png");
        if (url != null) {
            return new ImageIcon(url);
        } else {
            return null;
        }
    }

    private void addMenu(String menuName, int index) {
        int length = menuItems[index].length;
        MenuItem item = new MenuItem(menuName, index, length > 1);
        Icon icon = getIcon(menuName);
        if (icon != null) {
            item.setIcon(icon);
        }

        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (length > 1) { // Menu has submenus
                    if (!item.isSelected()) {
                        item.setSelected(true);
                        addSubMenu(item, index, length, getComponentZOrder(item));
                    } else {
                        hideMenu(item, index);
                        item.setSelected(false);
                    }
                } else {
                    // Open a new page when a submenu item is clicked
                    System.out.println(menuName + " clicked!");
                    
                }
            }
        });

        add(item);
        revalidate();
        repaint();
    }

    

    private void addSubMenu(MenuItem item, int index, int length, int indexZorder) {
        JPanel panel = new JPanel(new MigLayout("Wrap 1, fillx, gapy 0, inset 0", "fill"));
        panel.setName(index + "");
        panel.setOpaque(false);
        for (int i = 1; i < length; i++) {
            MenuItem subItem = new MenuItem(menuItems[index][i], i, false);
            subItem.initSubMenu(i, length);
            subItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    // Open a new page when a submenu item is clicked
                    
                }
            });
            panel.add(subItem);
        }
        add(panel, indexZorder + 1);

        revalidate();
        repaint();
    }

    private void hideMenu(MenuItem item, int index) {
        for (Component com : getComponents()) {
            if (com instanceof JPanel && com.getName() != null && com.getName().equals(index + "")) {
                remove(com);
                break;
            }
        }
        revalidate();
        repaint();
    }
}
