/*
- Controller단 로직 처리.
 */
package dev.mvc.categrp;
 
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategrpCont {
  @Autowired
  @Qualifier("dev.mvc.categrp.CategrpProc")
  private CategrpProcInter categrpProc;
  
  public CategrpCont() {
    System.out.println("-> CategrpCont created.");
  }
 
  /**
   * 새로고침을 방지
   * @return
   */
  @RequestMapping(value="/categrp/msg.do", method=RequestMethod.GET)
  public ModelAndView msg(String url){
    ModelAndView mav = new ModelAndView();
    mav.setViewName(url); // url을 받아서 url로 forward
    return mav; // forward
  }  
  
  // http://localhost:9091/categrp/create.do
  /**
   * 등록 폼
   * @return
   */
  @RequestMapping(value="/categrp/create.do", method=RequestMethod.GET )
  public ModelAndView create() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/categrp/create"); // webapp/WEB-INF/views/categrp/create.jsp
    
    return mav; // forward
  }
  
  // http://localhost:9091/categrp/create.do
  /**
   * 등록 처리
   * @param categrpVO
   * @return
   */
  @RequestMapping(value="/categrp/create.do", method=RequestMethod.POST )
  public ModelAndView create(CategrpVO categrpVO) { // categrpVO 자동 생성, Form -> VO
    // CategrpVO categrpVO <FORM> 태그의 값으로 자동 생성됨.
    // request.setAttribute("categrpVO", categrpVO); 자동 실행
    
    ModelAndView mav = new ModelAndView();
    
    System.out.println("--> categrpno: " + categrpVO.getCategrpno());
    
    int cnt = this.categrpProc.create(categrpVO); // 등록 처리
    mav.addObject("cnt", cnt); // request에 저장, request.setAttribute("cnt", cnt)
    mav.addObject("name", categrpVO.getName());  // 2) redirert 해도 name 객체를 출력하기 위한 방법, 추가해주기
    
    mav.addObject("url", "/categrp/create_msg");  // /categrp/create_msg -> /categrp/create_msg.jsp
    mav.setViewName("redirect:/categrp/msg.do"); // 1) redirect시 객체 사라짐, msg에서 param.name은 전달 못받음
    //mav.setViewName("/categrp/create_msg"); // /webapp/WEB-INF/views/categrp/create_msg.jsp

    return mav; // forward
  }
  
  // http://localhost:9091/categrp/list.do
  /**
   * 목록
   * @return
   */
  @RequestMapping(value="/categrp/list.do", method=RequestMethod.GET )
  public ModelAndView list() {
    ModelAndView mav = new ModelAndView();
    // 등록 순서별 출력    
    List<CategrpVO> list = this.categrpProc.list_categrpno_asc();
    
    // 출력 순서별 출력
    // List<CategrpVO> list = this.categrpProc.list_seqno_asc();
    mav.addObject("list", list); // request.setAttribute("list", list);

    mav.setViewName("/categrp/list"); // /WEB-INF/views/categrp/list.jsp
    return mav;
  }
  
}