/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.*;
import Model.CTPhieuNhap;
import java.util.List;

/**
 *
 * @author NHT_Kurumi
 */
public class CTPhieuNhapService {
    
    private CTPhieuNhapDAO ctphieunhapDAO;
    
    public CTPhieuNhapService(){
        ctphieunhapDAO= new CTPhieuNhapDAO();
    }
    
    public List<CTPhieuNhap> getListCTPNbyMaPN(String mapn){
        return ctphieunhapDAO.getListCTPNbyMaPN(mapn);
    }
    
    public void addCTPhieuNhap(CTPhieuNhap ctpn){
        ctphieunhapDAO.addCTPhieuNhap(ctpn);
    }
    
    public void updateCTPhieuNhap(CTPhieuNhap ctpn){
        ctphieunhapDAO.updateCTPhieuNhap(ctpn);
    }
    
    public void deleteCTPhieuNhap(String mapn){
        ctphieunhapDAO.deleteCTPhieuNhap(mapn);
    }
}
