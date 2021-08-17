/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.PhieuNhapDAO;
import Model.PhieuNhap;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author NHT_Kurumi
 */
public class PhieuNhapService {

    private PhieuNhapDAO phieunhapDAO;

    public PhieuNhapService() {
        phieunhapDAO = new PhieuNhapDAO();
    }

    public List<PhieuNhap> getListPN() {
        return phieunhapDAO.getListPN();
    }

    public List<PhieuNhap> getListPNbyMaPN(String mapn) {
        return phieunhapDAO.getListPNbyMaPN(mapn);
    }

    public List<PhieuNhap> getListPNbyNgayNhap(Date ngaynhap1, Date ngaynhap2) {
        return phieunhapDAO.getListPNbyNgayNhap(ngaynhap1, ngaynhap2);
    }

    public PhieuNhap getPhieuNhapByMaPN(String mapn) {
        return phieunhapDAO.getPhieuNhapByMaPN(mapn);
    }

    public void addPhieuNhap(PhieuNhap pn) {
        phieunhapDAO.addPhieuNhap(pn);
    }

    public void updatePhieuNhap(PhieuNhap pn) {
        phieunhapDAO.updatePhieuNhap(pn);
    }

    public void deletePhieuNhap(String mapn) {
        phieunhapDAO.deletePhieuNhap(mapn);
    }

    public ResultSet countMaPN(String dem) {
        return phieunhapDAO.countMaPN(dem);
    }

    public ResultSet getByMaPN(String mapn) {
        return phieunhapDAO.getByMaPN(mapn);
    }
}
