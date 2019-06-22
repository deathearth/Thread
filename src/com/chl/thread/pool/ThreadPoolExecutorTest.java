package com.chl.thread.pool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;
import java.util.concurrent.TimeUnit;

/**
 * 线程池执行器ThreadPoolExecutor，可自定义线程池，构造方法有多个重载，按需处理 <br>
 * 这里目的是创建，最优结构的线程池创建及代码结构，请根据实际情况设计
 * 
 * @author chenhailong
 */
public class ThreadPoolExecutorTest {
	/**
	 * 核心线程数
	 */
	static final Integer ThreadCoreNums = 20;
	/**
	 * 最大线程数
	 */
	static final Integer ThreadMaxNums = 50;
	/**
	 * 线程存活时间
	 */
	static final long LiveTime = 60;
	/**
	 * 队列存放长度
	 */
	static final Integer QueueSize = 1000;

	/**
	 * 存储队列结构
	 * 直接提交工作队列的默认选项是 SynchronousQueue，它将任务直接提交给线程而不保持它们。在此，如果不存在可用于立即运行任务的线程，则试图把任务加入队列将失败，因此会构造一个新的线程。此策略可以避免在处理可能具有内部依赖性的请求集时出现锁。
	 * 直接提交通常要求无界 maximumPoolSizes 以避免拒绝新提交的任务。当命令以超过队列所能处理的平均数连续到达时，此策略允许无界线程具有增长的可能性。
	 * 
	 * 无界队列使用无界队列（例如，不具有预定义容量的 LinkedBlockingQueue）将导致在所有 corePoolSize 线程都忙时新任务在队列中等待。这样，创建的线程就不会超过 corePoolSize。
	 * （因此，maximumPoolSize 的值也就无效了。）当每个任务完全独立于其他任务，即任务执行互不影响时，适合于使用无界队列；例如，在 Web 页服务器中。这种排队可用于处理瞬态突发请求，当命令以超过队列所能处理的平均数连续到达时，此策略允许无界线程具有增长的可能性。
	 * 
	 * 有界队列当使用有限的 maximumPoolSizes 时，有界队列（如 ArrayBlockingQueue）有助于防止资源耗尽，但是可能较难调整和控制。队列大小和最大池大小可能需要相互折衷：
	 * 使用大型队列和小型池可以最大限度地降低 CPU 使用率、操作系统资源和上下文切换开销，但是可能导致人工降低吞吐量。如果任务频繁阻塞（例如，如果它们是 I/O 边界），则系统可能为超过您许可的更多线程安排时间。
	 * 使用小型队列通常要求较大的池大小，CPU 使用率较高，但是可能遇到不可接受的调度开销，这样也会降低吞吐量。
	 */
	static final BlockingQueue<Runnable> bq = new LinkedBlockingQueue<Runnable>();

	/**
	 * 任务拒绝策略 4种
	 * abortPolicy在默认的 ThreadPoolExecutor.AbortPolicy 中，处理程序遭到拒绝将抛出运行时 RejectedExecutionException。
	 * CallerRunsPolicy在 ThreadPoolExecutor.CallerRunsPolicy 中，线程调用运行该任务的 execute 本身。此策略提供简单的反馈控制机制，能够减缓新任务的提交速度。
	 * DiscardPolicy在 ThreadPoolExecutor.DiscardPolicy 中，不能执行的任务将被删除。
	 * DiscardOldestPolicy在 ThreadPoolExecutor.DiscardOldestPolicy 中，如果执行程序尚未关闭，则位于工作队列头部的任务将被删除，然后重试执行程序（如果再次失败，则重复此过程）。
	 */
	static final DiscardPolicy dp = new ThreadPoolExecutor.DiscardPolicy();

	public static void main(String[] args) {

		ThreadPoolExecutor pool = new ThreadPoolExecutor(ThreadCoreNums, ThreadMaxNums, LiveTime, TimeUnit.SECONDS, bq,
				dp);

		pool.execute(() -> {
			System.out.println("线程池中处理线程业务!");
		});
		
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				try {
					//增加钩子函数，在系统关闭前关闭线程池
					pool.shutdown(); 
				} catch (Throwable e) {
				}
			}
		});
	}

}
