/*
 * <p>LinkQueue.java</p>
 */
package com.bigears.book.concurrency;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Project : myworld
 * @ClassName : com.bigears.book.concurrency.LinkQueue
 * @Description: 15.4.2 非阻塞队列
 * @Author : shenyang
 * @Date : 2016年1月20日 上午10:03:56
 */
public class LinkQueue<E> {

	private static class Node<E> {
		private E item;
		private AtomicReference<Node<E>> next;

		public Node(E item, AtomicReference<Node<E>> next) {
			this.item = item;
			this.next = next;
		}
	}

	private final Node<E> dummy = new Node<E>(null, null);
	private final AtomicReference<Node<E>> head = new AtomicReference<Node<E>>(dummy);
	private final AtomicReference<Node<E>> tail = new AtomicReference<Node<E>>(dummy);

	public boolean put(E item) {
		Node<E> newNode = new Node<E>(item, null);
		while (true) {
			Node<E> curTail = tail.get();
			Node<E> tailNext = curTail.next.get();
			if (curTail == tail.get()) {
				if (tailNext != null) {
					// 队列处于中间状态，推进尾节点
					tail.compareAndSet(curTail, tailNext);
				} else {
					// 队列处于稳定状态，尝试插入新节点
					if (curTail.next.compareAndSet(tailNext, newNode)) {
						// 插入成功，尝试推荐尾节点
						tail.compareAndSet(curTail, newNode);
						return true;
					}
				}
			}
		}
	}

	// 自己写的take方法，有待验证
	public E take() {
		while (true) {
			Node<E> curHead = head.get();
			Node<E> curTail = tail.get();
			Node<E> first = curHead.next.get();
			if (curHead == head.get()) {
				if (curHead == curTail) {
					if (first == null) {
						return null;
					} else {
						tail.compareAndSet(curTail, first);
					}
				}
				// 将head节点指到其next节点
				else if (head.compareAndSet(curHead, first)) {
					E item = head.get().item;
					if (item != null) {
						first.item = null;
						return item;
					}
				}
			}
		}
	}

}
