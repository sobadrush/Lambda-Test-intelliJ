//package mmb.txn.mcd.mcdot.mcdot002.utils;
//
//import java.math.BigDecimal;
//import java.util.Arrays;
//import java.util.List;
//
//import mmb.txn.mcd.mcdot.mcdot002.msg.MCDOT002_Color;
//
//public enum Project_Config {
//
//	H001("H001", "上市限時加碼",
//			null,
//			null,
//			null, null,
//			null, null,
//			"PJ_ITEM_01.png",
//			"CUBE_PJ_INFO_URL_H001"),
//	A001("A001", "玩數位",
//			new MCDOT002_Color(28, 137, 196),
//			Arrays.asList(new MCDOT002_Color(28, 137, 196, new BigDecimal("0.92")),
//						  new MCDOT002_Color(7, 74, 110, new BigDecimal("0.92"))),
//			"PJ_ICON_A001.png", "PJ_ICON2_A001.png",
//			"PJ_CDBG_1_A001.png", "PJ_CDBG_2_A001.png",
//			"PJ_ITEM_02.png",
//			"CUBE_PJ_INFO_URL_A001"),
//	A003("A003", "趣旅行",
//			new MCDOT002_Color(0, 153, 78),
//			Arrays.asList(new MCDOT002_Color(0, 153, 78, new BigDecimal("0.92")),
//						  new MCDOT002_Color(0, 81, 42, new BigDecimal("0.92"))),
//			"PJ_ICON_A003.png", "PJ_ICON2_A003.png",
//			"PJ_CDBG_1_A003.png", "PJ_CDBG_2_A003.png",
//			"PJ_ITEM_02.png",
//			"CUBE_PJ_INFO_URL_A003"),
//	A002("A002", "樂響購",
//			new MCDOT002_Color(103, 110, 213),
//			Arrays.asList(new MCDOT002_Color(103, 110, 213, new BigDecimal("0.92")),
//						  new MCDOT002_Color(60, 63, 145, new BigDecimal("0.92"))),
//			"PJ_ICON_A002.png", "PJ_ICON2_A002.png",
//			"PJ_CDBG_1_A002.png", "PJ_CDBG_2_A002.png",
//			"PJ_ITEM_02.png",
//			"CUBE_PJ_INFO_URL_A002"),
//	UNKNOWN("", "未知方案",
//			new MCDOT002_Color(176, 176, 176),
//			Arrays.asList(new MCDOT002_Color(153, 153, 153, new BigDecimal("0.92")),
//					new MCDOT002_Color(107, 107, 107, new BigDecimal("0.92"))),
//			"PJ_ICON_DEFAULT.png", "PJ_ICON2_DEFAULT.png",
//			"PJ_CDBG_1_DEFAULT.png", "PJ_CDBG_2_DEFAULT.png",
//			"PJ_ITEM_02.png",
//			"CUBE_PJ_INFO_URL_H001");
//
//	private String groupId; // 方案代碼
//	private String groupDesc; // 方案名稱
//	private MCDOT002_Color mainColor; // 方案主色
//	private List<MCDOT002_Color> gradientColor; // 漸層色
//	private String projectIconImg; // 方案圖示
//	private String projectIcon2Img; // 方案圖示 for 方案紀錄, 回饋明細
//	private String cardBg1Img; // 卡片背景(總覽)
//	private String cardBg2Img; // 卡片背景(說明)
//	private String itemImg; // 回饋項目圖示
//	private String infoUrl; // 適用消費說明 Url
//
//	Project_Config(String groupId, String groupDesc, MCDOT002_Color mainColor, List<MCDOT002_Color> gradientColor,
//			String projectIconImg, String projectIcon2Img, String cardBg1Img, String cardBg2Img, String itemImg,
//			String infoUrl) {
//		this.groupId = groupId;
//		this.groupDesc = groupDesc;
//		this.mainColor = mainColor;
//		this.gradientColor = gradientColor;
//		this.projectIconImg = projectIconImg;
//		this.projectIcon2Img = projectIcon2Img;
//		this.cardBg1Img = cardBg1Img;
//		this.cardBg2Img = cardBg2Img;
//		this.itemImg = itemImg;
//		this.infoUrl = infoUrl;
//	}
//
//	/**
//	 * 依 groupId 查找 config
//	 * 
//	 * @param groupId
//	 * @return
//	 */
//	public static Project_Config findByGroupId(String groupId) {
//		for (Project_Config config : Project_Config.values()) {
//			if (config.getGroupId().equals(groupId)) {
//				return config;
//			}
//		}
//		return UNKNOWN;
//	}
//
//	public String getGroupId() {
//		return groupId;
//	}
//
//	public void setGroupId(String groupId) {
//		this.groupId = groupId;
//	}
//
//	public String getGroupDesc() {
//		return groupDesc;
//	}
//
//	public void setGroupDesc(String groupDesc) {
//		this.groupDesc = groupDesc;
//	}
//
//	public MCDOT002_Color getMainColor() {
//		return mainColor;
//	}
//
//	public void setMainColor(MCDOT002_Color mainColor) {
//		this.mainColor = mainColor;
//	}
//
//	public List<MCDOT002_Color> getGradientColor() {
//		return gradientColor;
//	}
//
//	public void setGradientColor(List<MCDOT002_Color> gradientColor) {
//		this.gradientColor = gradientColor;
//	}
//
//	public String getProjectIconImg() {
//		return projectIconImg;
//	}
//
//	public void setProjectIconImg(String projectIconImg) {
//		this.projectIconImg = projectIconImg;
//	}
//
//	public String getProjectIcon2Img() {
//		return projectIcon2Img;
//	}
//
//	public void setProjectIcon2Img(String projectIcon2Img) {
//		this.projectIcon2Img = projectIcon2Img;
//	}
//
//	public String getCardBg1Img() {
//		return cardBg1Img;
//	}
//
//	public void setCardBg1Img(String cardBg1Img) {
//		this.cardBg1Img = cardBg1Img;
//	}
//
//	public String getCardBg2Img() {
//		return cardBg2Img;
//	}
//
//	public void setCardBg2Img(String cardBg2Img) {
//		this.cardBg2Img = cardBg2Img;
//	}
//
//	public String getItemImg() {
//		return itemImg;
//	}
//
//	public void setItemImg(String itemImg) {
//		this.itemImg = itemImg;
//	}
//
//	public String getInfoUrl() {
//		return infoUrl;
//	}
//
//	public void setInfoUrl(String infoUrl) {
//		this.infoUrl = infoUrl;
//	}
//}
