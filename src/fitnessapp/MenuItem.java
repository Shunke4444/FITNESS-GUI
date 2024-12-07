/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fitnessapp;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author User
 */
public class MenuItem extends JButton{

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * @return the subMenuAble
     */
    public boolean isSubMenuAble() {
        return subMenuAble;
    }

    /**
     * @param subMenuAble the subMenuAble to set
     */
    public void setSubMenuAble(boolean subMenuAble) {
        this.subMenuAble = subMenuAble;
    }

    /**
     * @return the subMenuIndex
     */
    public int getSubMenuIndex() {
        return subMenuIndex;
    }

    /**
     * @param subMenuIndex the subMenuIndex to set
     */
    public void setSubMenuIndex(int subMenuIndex) {
        this.subMenuIndex = subMenuIndex;
    }

    /**
     * @return the lengths
     */
    public int getLengths() {
        return lengths;
    }

    /**
     * @param lengths the lengths to set
     */
    public void setLengths(int lengths) {
        this.lengths = lengths;
    }
    private int index;
    private boolean subMenuAble;
    
    private int subMenuIndex;
    private int lengths;
    
    public MenuItem(String name, int index, boolean subMenuAble){
        super(name);
        this.index=index;
        this.subMenuAble=subMenuAble;
        setContentAreaFilled(false);
        setHorizontalAlignment(SwingConstants.LEFT);
        setBorder(new EmptyBorder(9,10,9,10));
        setIconTextGap(10);
        
    }
    
    public void initSubMenu(int subMenuIndex, int length){
        this.subMenuIndex =subMenuIndex;
        this.lengths=length;
        setBorder(new EmptyBorder(9,50,9,10));
        setBackground(new Color(241,91,50));
        setOpaque(true);
    }
}
