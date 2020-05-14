//package com.chl.tools;
//
//import java.util.concurrent.TimeUnit;
//
//import com.google.common.cache.Cache;
//import com.google.common.cache.CacheBuilder;
//
//@Service("shortUrlService")
//public class ShortUrls implements shortUrlService {
//
//	private static Cache<String, String> cache = CacheBuilder.newBuilder()
//			// 设置cache的初始大小为100，要合理设置该值
//			.initialCapacity(100)
//			// 最大缓存数量1万
//			.maximumSize(10000)
//			// 设置并发数为5，即同一时间最多只能有5个线程往cache执行写入操作
//			.concurrencyLevel(5)
//			// 设置cache中的数据在写入之后的存活时间为60分钟
//			.expireAfterWrite(3600, TimeUnit.SECONDS)
//			// 构建cache实例
//			.build();
//
//	@Override
//	public String getShortUrl(String longUrl) {
//		// 如果已经存在直接返回
//		ShortUrlDO target = shortUrlDao.getByLongUrl(longUrl);
//		if (target != null) {
//			return config.getShortDomainPath() + target.getShortId();
//		}
//
//		// 生成全局唯一id
//		long id = sequenceService.next(SequenceService.SHORT_URL);
//
//		// 转换成32进制
//		String shortId = Utils.to32hex(id);
//
//		// 保存db，然后返回
//		target = new ShortUrlDO();
//		target.setLongUrl(longUrl);
//		target.setShortId(shortId);
//		target.setStatus(1);
//
//		shortUrlDao.insert(target);
//
//		return config.getShortDomainPath() + shortId;
//	}
//
//	@Override
//	public String getLongUrl(String shortId) {
//		// 查询缓存
//		String longUrl = cache.getIfPresent(shortId);
//		if (longUrl != null) {
//			return longUrl;
//		}
//
//		// 查询db
//		ShortUrlDO target = shortUrlDao.getByShortId(shortId);
//		if (target == null) {
//			return null;
//		} else {
//			cache.put(shortId, target.getLongUrl());
//		}
//		return target.getLongUrl();
//	}
//
//}
