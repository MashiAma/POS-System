/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import ViewComponents.MenuItems;
import ViewComponents.EventSelected;
import Model.MenuModel;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;

/**
 *
 * @author Hp
 */
public class MenuController <E extends Object> extends JList<E>{

    private final DefaultListModel model;
    private int selectedIndex=-1;
     private EventSelected event;
    public void addEventSelected(EventSelected event){
        this.event=event;
    }
    
    public MenuController() {
        model=new DefaultListModel();
        setModel(model);
        addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                if(SwingUtilities.isLeftMouseButton(e))
                {
                    int index = locationToIndex(e.getPoint());
                    Object object1= model.getElementAt(index);
                    if(object1 instanceof MenuModel){
                        MenuModel menu1= (MenuModel) object1;
                        if(menu1.getType()== MenuModel.MenuType.MENU){
                            selectedIndex=index;
                            if(event!=null)
                            {
                               event.selected(index);
                            }
                        }
                    else{
                           selectedIndex=index; 
                        }
                        repaint();
                    }
                }
                 // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
            }
            
        });
    }

    @Override
    public ListCellRenderer<? super E> getCellRenderer() {
        return new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object object1, int index1, boolean isBool1, boolean isBool2) {
                MenuModel value;
                if(object1 instanceof MenuModel){
                    value= (MenuModel) object1;
               }
                else{
                    value= new MenuModel("", object1+ "",MenuModel.MenuType.EMPTY);
                }
                MenuItems item1= new MenuItems(value);
                item1.setSelected(selectedIndex==index1);
                return item1;
            }// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
          
            
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    
        };
    }
    public void addItems(MenuModel value){
        model.addElement(value);
    }
}
