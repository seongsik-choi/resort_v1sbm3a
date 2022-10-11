/*
- Process(Manager, Service): DBMS 접속이 아닌 알고리즘 및 제어문 선언
- DAO interface 메소드 재사용 또는 신규 생성 가능.
 */
package dev.mvc.categrp;
import java.util.List;
 
public interface CategrpProcInter {
  /**
   * 등록
   * @param categrpVO
   * @return 등록된 레코드 갯수
   */
  public int create(CategrpVO categrpVO);
  
  /**
   * 등록 순서별 목록
   * @return
   */
  public List<CategrpVO> list_categrpno_asc();  
 
  /**
   * 조회, 수정폼
   * @param categrpno 카테고리 그룹 번호, PK
   * @return
   */
  public CategrpVO read(int categrpno);  
  
  /**
   * 수정 처리
   * @param categrpVO
   * @return 처리된 레코드 갯수
   */
  public int update(CategrpVO categrpVO); 
  
  /**
   * 삭제 처리
   * @param categrpno
   * @return 처리된 레코드 갯수
   */
  public int delete(int categrpno);  
}