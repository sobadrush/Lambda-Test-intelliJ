//package mmb.txn.mcd.mcdot.mcdot002.task;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.config.BeanDefinition;
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Service;
//
//import com.cathaybk.eairest.message.cbecpromotionlst.CBECPROMOTIONLSTRS;
//import com.cathaybk.eairest.message.ccpbntcap04q001.CCPBNTCAP04Q001RS;
//import com.cathaybk.eairest.message.ccpbntuse27q001.CCPBNTUSE27Q001RS;
//import com.cathaybk.eairest.message.odsbmisfbdesq001.ODSBMISFBDESQ001RS;
//import com.ibm.tw.commons.code.ErrorCode;
//import com.ibm.tw.commons.exception.ActionException;
//import com.ibm.tw.commons.util.StringUtils;
//import com.ibm.tw.commons.util.time.DateUtils;
//
//import mmb.bo.MMBUser;
//import mmb.task.MMBTask;
//import mmb.txn.mcd.mcdot.mcdot002.msg.MCDOT002_110_Rq;
//import mmb.txn.mcd.mcdot.mcdot002.msg.MCDOT002_110_Rs;
//import mmb.txn.mcd.mcdot.mcdot002.msg.MCDOT002_Project;
//import mmb.txn.mcd.mcdot.mcdot002.utils.MCDOT002Utils;
//import mmb.txn.mcd.mcdot.mcdot002.utils.Project_Config;
//import mmb.txn.mcd.utils.MCDUtils;
///**
// * CUBE 回饋加碼(XYZ) - 方案總覽頁
// */
//
//@Service("MCDOT002_110")
//@Scope(BeanDefinition.SCOPE_PROTOTYPE)
//public class MCDOT002_110 extends MMBTask<MCDOT002_110_Rq, MCDOT002_110_Rs>{
//
//	@Autowired
//	private MCDUtils mcdUtils;
//
//	@Autowired
//	private MCDOT002Utils mcdot002Utils;
//
//	@Override
//	public void validate(MCDOT002_110_Rq rqData) throws ActionException {
//		
//	}
//
//	@Override
//	public void handle(MCDOT002_110_Rq rqData, MCDOT002_110_Rs rsData) throws ActionException {
//		MMBUser mmbUser = getLoginUser();
//		// 取得目前方案名稱
//		CCPBNTCAP04Q001RS ccpbntcap04Q001RS = mcdUtils.sendCCPBNTCAP04Q001(mmbUser.getUid());
//		// 取得總小樹點(信用卡)
//		CCPBNTUSE27Q001RS ccpbntuse27Q001RS = mcdUtils.sendCCPBNTUSE27Q001(mmbUser.getUid());
//		// 取得方案資訊
//		ODSBMISFBDESQ001RS odsbmisfbdesq001RS = mcdot002Utils.sendODSBMISFBDESQ001();
//		
//		// 如果電文資料為空，則直接錯誤
//		if (ccpbntcap04Q001RS == null || ccpbntcap04Q001RS.getTRANRS() == null || ccpbntuse27Q001RS == null
//				|| ccpbntuse27Q001RS.getTRANRS() == null || odsbmisfbdesq001RS == null
//				|| odsbmisfbdesq001RS.getTRANRS() == null) {
//			throwActionException(ErrorCode.DATA_NOT_FOUND);
//		}
//		
//		// 目前方案 ID
//		String groupId = ccpbntcap04Q001RS.getTRANRS().getGROUP_ID();
//		rsData.setCurrentGroupId(groupId); // 目前方案代碼
//		rsData.setCurrentGroupDesc(ccpbntcap04Q001RS.getTRANRS().getGROUP_DESC()); // 目前方案名稱
//		rsData.setPointCurrent(new BigDecimal(ccpbntuse27Q001RS.getTRANRS().getPOINT_CURRENT())); // 總小樹點(信用卡)
//		
//		// 產生方案
//		Map<String, MCDOT002_Project> projectMap = mcdot002Utils.buildProjectList(groupId, odsbmisfbdesq001RS.getTRANRS());
//		// 方案總覽顯示資訊
//		MCDOT002_Project home = projectMap.get(Project_Config.H001.getGroupId());
//		rsData.setInfoUrl(home.getInfoUrl()); // 適用消費說明 Url
//		// 方案列表
//		rsData.setProjectList(new ArrayList<>(mcdot002Utils.getSortProjectListByCurrentGroupId(projectMap, groupId)));
//		
//		
//	}
//
//	/**
//	 * 查發電文: 個人專屬商戶活動優惠列表查詢服務
//	 */
//	private CBECPROMOTIONLSTRS sendCBECPROMOTIONLST(String uid) {
//		return new CBECPROMOTIONLSTRS();
//	}
//	
//	/**
//	 * @param uid
//	 * @param registStatus 0:未登錄，1:已登錄
//	 */
//	private List<com.cathaybk.eairest.message.cbecpromotionlst.beans.rs.Record> getCubeGiveBackList(String uid, String registStatus) {
//		return this.sendCBECPROMOTIONLST(uid).getTRANRS().getRecords().stream()
//				.filter(record -> StringUtils.equals(record.getRegisterFlag(), registStatus))
//				.sorted((r1, r2) -> {
//					Date d1 = DateUtils.getDateByDateFormat(r1.getTxnDateEnd(), "yyyy/MM/dd");
//					Date d2 = DateUtils.getDateByDateFormat(r2.getTxnDateEnd(), "yyyy/MM/dd");
//					return d1.compareTo(d2);
//				}).collect(Collectors.toList());
//		
//	}
//}
