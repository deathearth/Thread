package com.chl;

public class Test {

	public static void main(String[] args) {
		
		String str = "bbs_forum.pic\n" + 
				" bbs_post.user_header\n" + 
				" bbs_post.image\n" + 
				" bbs_post.project_pic\n" + 
				" bbs_post.product_pic\n" + 
				" bbs_post_comment.user_header\n" + 
				" bbs_post_comment.reply_user_header\n" + 
				" bbs_post_comment.content\n" + 
				" bbs_post_comment.pics\n" + 
				" ej_bbs_post.user_header\n" + 
				" ej_bbs_post_comment.user_header\n" + 
				" ej_bbs_post_comment.reply_user_header\n" + 
				"point_ecommerce_task.link_url";
		

//		String str = "CROWDFUNDING_ADVERT.URL\n" + 
//				"CROWDFUNDING_ADVERT.PHOTO\n" + 
//				"CROWDFUNDING_ADVERT_FLOW.URL\n" + 
//				"CROWDFUNDING_ANNOUNCEMENT.ANNOUNCEMENT_URL\n" + 
//				"CROWDFUNDING_ANNOUNCEMENT.ANNOUNCE_CONTENT\n" + 
//				"CROWDFUNDING_CALLED_RETURN_LOG.REQUEST_CONTENT\n" + 
//				"CROWDFUNDING_CALLED_RETURN_LOG.RESPONSE_CONTENT\n" + 
//				"CROWDFUNDING_MARKER.URL\n" + 
//				"CROWDFUNDING_MARKER.MOBILE_ICON\n" + 
//				"CROWDFUNDING_PROJECT.CONTENT_DESC\n" + 
//				"CROWDFUNDING_PROJECT.CONTENT\n" + 
//				"CROWDFUNDING_PROJECT.VIDEO\n" + 
//				"CROWDFUNDING_PROJECT.PIC\n" + 
//				"CROWDFUNDING_PROJECT.WEB_VIDEO_PIC\n" + 
//				"CROWDFUNDING_PROJECT.MOBILE_VIDEO_PIC\n" + 
//				"CROWDFUNDING_PROJECT.MOBILE_PIC\n" + 
//				"CROWDFUNDING_PROJECT.MOBILE_VIDEO\n" + 
//				"CROWDFUNDING_PROJECTCHECKLOG.MESSAGE\n" + 
//				"CROWDFUNDING_PROJECTCOMMENTS.CONTENT\n" + 
//				"CROWDFUNDING_PROJECTCOMMENTS.PICS\n" + 
//				"CROWDFUNDING_PROJECTDISCLOSURE.ATTACHMENTS\n" + 
//				"CROWDFUNDING_PROJECTDISCLOSURE.CONTENT\n" + 
//				"CROWDFUNDING_PROJECTNEWS.CONTENT\n" + 
//				"CROWDFUNDING_PROJECTSUPPORTLOG.REMARK\n" + 
//				"CROWDFUNDING_PROJECT_TYPE.NAME\n" + 
//				"CROWDFUNDING_SUPPORTITEM.KEY_INFO\n" + 
//				"CROWDFUNDING_SUPPORTITEM.PIC_URL\n" + 
//				"CROWDFUNDING_USER.HEADER\n" + 
////				"-- CROWDFUNDING_USER.EMAIL\n" + //--
//				"T_APP_PACKINFO.URL\n" + 
////				"-- T_AUTH_ORGANIZE.EMAIL\n" + //--
//				"T_AUTH_USERS.PHOTOS\n" + 
//				"T_AUTH_USERS.REASON\n" + 
//				"T_BACKUP_DATA.BACK_DATA\n" + 
////				"-- T_BANNER.ACT_VALUE\n" + //--
//				"T_BANNER.PIC\n" + 
//				"T_CITY_PAGE.PIC\n" + 
//				"T_CONSUMER_COUPON.PIC_URL\n" + 
////				"-- T_CREDIT_USER.OPERATOR\n" + //--
//				"T_DEPOSIT_BANKS.PIC_URL\n" + 
//				"T_DISCOVERY.URL\n" + 
//				"T_DISCOVERY_CONTENT.LINK_URL\n" + 
//				"T_DISCOVERY_FLOW.PICS\n" + 
//				"T_DISCOVERY_FLOW.USERHEAD\n" + 
//				"T_DISCOVERY_TOPICDETAIL.PIC_URL\n" + 
//				"T_DISCUSS_THEME.HEAD_ICON\n" + 
//				"T_ECOMM_WE_PAGES.PAGE_URL\n" + 
//				"T_ECOMM_WE_PAGES.PIC\n" + 
//				"T_ECOMM_WE_PAGE_MODULES.MODULE_INFO\n" + 
//				"T_FEEDBACK.PICTURES\n" + 
////				"-- T_HUANXIN_MSG_HISTORY.BODIES\n" +  //--
////				"-- T_HUANXIN_MSG_HISTORY.MSG\n" + //--
//				"T_ITEM.DRP_SELL_PIC\n" + 
//				"T_ITEM.DETAIL\n" + 
//				"T_ITEM.IMG\n" + 
//				"T_ITEM.SPECIFICATION\n" + 
//				"T_ITEM_ADVERT.ADVERT_URL\n" + 
//				"T_ITEM_LABEL.PIC\n" + 
//				"T_ITEM_LABEL.ICON\n" + 
//				"T_ITEM_SELLER.HAS_PROJECT\n" + 
//				"T_LIVE.PIC_URL\n" + 
////				"-- T_NEWTRAINING_TASKLIST.VALUE\n" + //--
////				"-- T_PAYAPPLIES.CONFIRM_OPERATOR_EMAIL\n" + //--
////				"-- T_PAYAPPLIES.OPERATOR_EMAIL\n" + //--
////				"-- T_PAYAPPLIES.RSVFLD1\n" + //--
//				"T_PROJECT_BANK.PIC\n" + 
//				"T_PROJECT_BRAND.LOGO_URL\n" + 
//				"T_PROJECT_EXT.CONTENT_EXT\n" + 
//				"T_PROJECT_EXTEND.BASE_INFO\n" + 
//				"T_PROJECT_EXTEND.PICS\n" + 
//				"T_PROJECT_EXTEND.PRE_BUSINESS\n" + 
//				"T_PROJECT_EXTEND.PRE_FEATURE\n" + 
//				"T_PROJECT_FILE.URL\n" + 
//				"T_PROJECT_INFO.MEMBERS\n" + 
//				"T_PROJECT_INFO.PRE_BUSINESS\n" + 
//				"T_PROJECT_INFO.PRE_FEATURE\n" + 
//				"T_PROJECT_INFO.PROJECT_BACKGROUND\n" + 
//				"T_PROJECT_INFO.ADDRESS\n" + 
//				"T_PROJECT_INFO.PICS\n" + 
//				"T_PROJECT_MEMBER.HEADER\n" + 
//				"T_PROJECT_PUSH_MSG.PROJECT_ID\n" + 
//				"T_PROJECT_QUALIFY_LINK_ING.URL\n" + 
//				"T_PROJECT_QUESTION.ANSWER_COTENT\n" + 
//				"T_PROJECT_TRACKING_NUMBER.URLS\n" + 
//				"T_QUESTION.CONTENT\n" + 
//				"T_SUPPORT_EXCHANGE.PROJECT_PIC\n" + 
//				"T_THEME_GROUP.PIC\n" + 
//				"T_THEME_GROUP.H5_URL\n" + 
////				"-- T_THIRD_TRAN_RECORD.CALLBACK_URL\n" + //--
//				"T_TOPIC.SHARE_URL\n" + 
//				"T_TOPIC.PIC_URL\n" + 
//				"T_TOPIC.DETAIL_LIST\n" + 
//				"T_USER_CONTRACT.CONTRACT_URL\n" + 
//				"T_USER_DRP_SHOP.HEADER";
		
		StringBuffer sb = new StringBuffer();
		
		String[] tableColumn = str.split("\n");
		for(int i = 0; i < tableColumn.length ;i++) {
			String table = tableColumn[i].split("\\.")[0];
			String column = tableColumn[i].split("\\.")[1];
			
			
//			sb.append("select ");
//			sb.append("REPLACE( ");
//			sb.append("REPLACE( ");
//			sb.append("REPLACE( ");
//			sb.append("REPLACE( ");
//			sb.append("REPLACE( ");
//			sb.append(column);
//			sb.append(",'static.kaishiba.com','static.deathearth.com') ");
//			sb.append(",'video.kaishiba.com','video.deathearth.com') ");
//			sb.append(",'doc.kaishiba.com','doc.deathearth.com') ");
//			sb.append(",'images.kaistart.com','images.deathearth.com') ");
//			sb.append(",'images.kaishiba.com','images.deathearth.com') ");
//			sb.append("from ");
//			sb.append(table );
//			sb.append(";");
//			sb.append("\n");
			
			
			
			sb.append("update  ");
			sb.append(table );
			sb.append(" set " );
			sb.append(column);
			sb.append("= " );
			sb.append("REPLACE( ");
			sb.append("REPLACE( ");
			sb.append("REPLACE( ");
			sb.append("REPLACE( ");
			sb.append("REPLACE( ");
			sb.append(column);
			sb.append(",'static.kaishiba.com','static.deathearth.com') ");
			sb.append(",'video.kaishiba.com','video.deathearth.com') ");
			sb.append(",'doc.kaishiba.com','doc.deathearth.com') ");
			sb.append(",'images.kaistart.com','images.deathearth.com') ");
			sb.append(",'images.kaishiba.com','images.deathearth.com') ");
			sb.append(";");
			sb.append("\n");
			
			
//			sb.append("update  ");
//			sb.append(table );
//			sb.append(" set " );
//			sb.append(column);
//			sb.append("= " );
//			sb.append("REPLACE( ");
//			sb.append("REPLACE( ");
//			sb.append("REPLACE( ");
//			sb.append("REPLACE( ");
//			sb.append(column);
//			sb.append(",'static.deathearth.com','static.kaishiba.com') ");
//			sb.append(",'video.deathearth.com','video.kaishiba.com') ");
//			sb.append(",'doc.deathearth.com','doc.kaishiba.com') ");
//			sb.append(",'images.deathearth.com','images.kaistart.com') ");
//			sb.append(";");
//			sb.append("\n");
			
			
		}
		
		System.out.println(sb.toString());
		
	}

}
