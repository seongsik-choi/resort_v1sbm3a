/*
DAO(Data Access Object): DBMS SQL 실행 객체
- MyBATIS에 선언된 <insert id="create" parameterType="CategrpVO"> 태그를  참조하여 자동으로 DAO class 생성
- 자동으로 생성된 DAO class는 MyBATIS를 호출
- MyBATIS의 <mapper namespace="dev.mvc.categrp.CategrpDAOInter">에 선언
- 스프링이 자동으로 구현

 */
package dev.mvc.categrp;
import java.util.List;

public interface CategrpDAOInter {
  
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
   * 조회, 수정, 삭제 폼
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