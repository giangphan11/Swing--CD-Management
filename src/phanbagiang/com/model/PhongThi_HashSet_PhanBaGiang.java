/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package phanbagiang.com.model;

/**
 *
 * @author Vu Duong
 */
import java.util.ArrayList;
import java.util.HashSet;

public class PhongThi_HashSet_PhanBaGiang  {
    //các thuộc tính của đối tượng phòng thi
    private String msPT;
    private String diachiPT;
    private int luongTS;
    //đối tượng dùng chứa tập các thí sinh
    private HashSet<ThiSinh>dsTS;
// dinh nghia cac phuong thuc tao lapconstructors
public PhongThi_HashSet_PhanBaGiang(String msPT, String diachiPT, int luongTS) {
    this.msPT = msPT;
    this.diachiPT = diachiPT;
    this.luongTS = luongTS;
    dsTS=new HashSet<ThiSinh>();
}
 /**
* Thêm 1 thí sinh vào phòng thi có kiểm tra trùng mã
* @param ts: thí sinh thêm vào
* @return true nếu việc thêm thành công
*/
public boolean themThiSinh(ThiSinh ts) {
//Nếu thí sinh đã tồn tại thì không cho thêm
    if(dsTS.contains(ts)) return false;
    if(dsTS.size()+1>luongTS)//nếu đã đủ lượng thí sinh
    {
        System.out.println("đã đủ số lượng thí sinh trong phòng.");
        return false;
    }
    else
    {   dsTS.add(ts);
        return true;
    }
}
/* Xóa 1 thí sinh khỏi phòng thi
* @param soBD là số báo danh của thí sinh cần xóa
* @return trả về true nếu xóa thành công
*/
public boolean xoaThisinh(String soBD) {
    ThiSinh ts=new ThiSinh(soBD);
    if(!dsTS.contains(ts))    return false;
    else
    {   dsTS.remove(ts);
        return true;
    }    
}
/**
* Sửa thông tin thí sinh
* @param soBD: số DB của thí sinh cần sử thông tin
* @param newTS: thông tin mới cần cập nhật
* @return true nếu sửa chữa thành công
*/
 public boolean suaThongtinTS(String soBD, ThiSinh newTS) {
    ThiSinh ts=new ThiSinh(soBD);
    if(!dsTS.contains(ts))    return false;
    dsTS.add(newTS);
    return true;
}
/**
* Lấy thông tin của 1 thí sinh khi biết số báo danh
* @param soBD số báo danh của ts cần lấy thông tin
* @return null nếu không lấy được
*/
public ThiSinh layThongtinTS(String soBD) {
    ThiSinh ts=new ThiSinh(soBD);
    if(!dsTS.contains(ts))     return null;
    //ts=dsTS.get(dsTS.indexOf(ts));
    for(ThiSinh thiSinh :dsTS) {
    	if(thiSinh.getSoBD().equalsIgnoreCase(soBD)) {
    		ts= thiSinh;
    	}
    }
    return ts;
}
/**
* Lấy thông tin của 1 thí sinh khi biết
*  số thứ tự của ts đó trong danh sách
* @param index :số thứ tự của ts
* @return null nếu không thành công

*/
/*
public ThiSinh layThongtinTS(int index){
    if(index<0||index>dsTS.size()) return null;
    return dsTS.get(index);
}

/**
* Lấy số thí sinh thực sự đang có trong phòng thi
* @return
*/
public int soThisinh() {
    return dsTS.size();
}

}

