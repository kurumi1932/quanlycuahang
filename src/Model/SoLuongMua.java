/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author NHT_Kurumi
 */
public class SoLuongMua {
    private String popupSLMua ;

    public SoLuongMua() {
    }

    public SoLuongMua(String popupSLMua) {
        this.popupSLMua = popupSLMua;
    }
    
    public String getSLMua() {
        return popupSLMua;
    }

    public void setSLMua(String SLMua) {
        this.popupSLMua = SLMua;
    }
}
