/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;
import Model.DashboardModel;
import View.DashboardView;
import javax.swing.JOptionPane;
/**
 *
 * @author Hp
 */
public class DashboardController {
    private DashboardView view;
    private DashboardModel model;

    public DashboardController(DashboardView view, DashboardModel model) {
        this.view = view;
        this.model = model;
    }

    public String retrieveDataFromDatabase1() {
        try {
            return DashboardModel.retrieveDataFromDatabase1();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Occured. Check Again", "Error", JOptionPane.ERROR_MESSAGE);
        return "";
        }
    }

    public String retrieveDataFromDatabase2() {
        try {
            return DashboardModel.retrieveDataFromDatabase2();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Occured. Check Again", "Error", JOptionPane.ERROR_MESSAGE);
        }return "";
        }
    }




