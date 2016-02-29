/*
 * <p>Watch.java</p>
 */
package com.bigears.base.io;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;

/**
 * @Project : myworld
 * @ClassName : com.bigears.base.io.Watch
 * @Description: nio变更通知,监控目录下的文件新建事件
 * @Author : shenyang
 * @Date : 2016年2月17日 上午9:46:04
 */
public class Watch {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {

		Path path = Paths.get("d:\\");
		System.out.println("Now watching the current directory ...");

		try {
			WatchService watcher = path.getFileSystem().newWatchService();
			path.register(watcher, StandardWatchEventKinds.ENTRY_CREATE);
			WatchKey watckKey = watcher.take();
			List<WatchEvent<?>> events = watckKey.pollEvents();
			for (WatchEvent event : events) {
				System.out.println("Someone just created the file '" + event.context().toString() + "'.");
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.toString());
		}

	}

}
