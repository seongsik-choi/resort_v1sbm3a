/*
 - DI(Dependency Injection: 의존 주입)의 구현
     - IoC(Inversion of Control, 제어의 역전): 개발자가 객체를 생성하는 것이 아니라,
       개발자가 객체를 사용하는 순간, Spring 콘트롤러가 객체를 생성하여 개발자에게 제공.
     - 필요한 객체를 개발자는 선언만하고 객체 생성은 Framework가.
 */
package dev.mvc.categrp;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
 
// Autowired 기능에의해 자동 할당될 때 사용되는 이름
@Component("dev.mvc.categrp.CategrpProc") // 자동으로 객체 생성이 필요한 Class에만 선언 가능
public class CategrpProc implements CategrpProcInter {
 
  @Autowired  // DI: Spring 자동으로 구현한 DAO class 객체를 할당
  private CategrpDAOInter categrpDAO;
  // private CategrpDAOInter categrpDAO = new CategrpDAO();

  @Override
  public int create(CategrpVO categrpVO) {
    int cnt = categrpDAO.create(categrpVO);
    return cnt;
  }

  @Override
  public List<CategrpVO> list_categrpno_asc() {
    // TODO Auto-generated method stub
    List<CategrpVO> list = null;
    list = this.categrpDAO.list_categrpno_asc();
    return list;
  }
  
}