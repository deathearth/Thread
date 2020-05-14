package com.chl.dataStruct.list;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 多读少写的业务场景可以使用
 * @author chenhailong
 * 在写入/删除的时候，才会从原来的数据复制一个副本出来，然后修改这个副本，最后把原数据替换成当前的副本。修改操作的同时，读操作不会被阻塞，而是继续读取旧的数据。
 * 读写锁读的是最新数据。
 * 
 * 
 * 
 *  缺点：频繁复制，占用内存，影响性能
 */
public class CopyOnWriteArrayListTest {

	public static void main(String[] args) {
		CopyOnWriteArrayList<String>  cwal = new CopyOnWriteArrayList<String>();
		cwal.add("abc");
	}
}


/**

## 源码实现：
public boolean add(E e) {
    final ReentrantLock lock = this.lock;
    lock.lock();
    try {
        Object[] elements = getArray();
        int len = elements.length;
        Object[] newElements = Arrays.copyOf(elements, len + 1);
        newElements[len] = e;
        setArray(newElements);
        return true;
    } finally {
        lock.unlock();
    }
}

**/