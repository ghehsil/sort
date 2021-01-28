package test;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Lists;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class maxAmountNumber {
    public static void main(String[] args) {
        ThreadPoolExecutor executor=new ThreadPoolExecutor
                (8, 8, 8L, TimeUnit.SECONDS,
                        new BlockingQueue<Runnable>() {
                    @Override
                    public boolean add(Runnable runnable) {
                        return false;
                    }

                    @Override
                    public boolean offer(Runnable runnable) {
                        return false;
                    }

                    @Override
                    public void put(Runnable runnable) throws InterruptedException {

                    }

                    @Override
                    public boolean offer(Runnable runnable, long timeout, TimeUnit unit) throws InterruptedException {
                        return false;
                    }

                    @Override
                    public Runnable take() throws InterruptedException {
                        return null;
                    }

                    @Override
                    public Runnable poll(long timeout, TimeUnit unit) throws InterruptedException {
                        return null;
                    }

                    @Override
                    public int remainingCapacity() {
                        return 0;
                    }

                    @Override
                    public boolean remove(Object o) {
                        return false;
                    }

                    @Override
                    public boolean contains(Object o) {
                        return false;
                    }

                    @Override
                    public int drainTo(Collection<? super Runnable> c) {
                        return 0;
                    }

                    @Override
                    public int drainTo(Collection<? super Runnable> c, int maxElements) {
                        return 0;
                    }

                    @Override
                    public Runnable remove() {
                        return null;
                    }

                    @Override
                    public Runnable poll() {
                        return null;
                    }

                    @Override
                    public Runnable element() {
                        return null;
                    }

                    @Override
                    public Runnable peek() {
                        return null;
                    }

                    @Override
                    public int size() {
                        return 0;
                    }

                    @Override
                    public boolean isEmpty() {
                        return false;
                    }

                    @Override
                    public Iterator<Runnable> iterator() {
                        return null;
                    }

                    @Override
                    public Object[] toArray() {
                        return new Object[0];
                    }

                    @Override
                    public <T> T[] toArray(T[] a) {
                        return null;
                    }

                    @Override
                    public boolean containsAll(Collection<?> c) {
                        return false;
                    }

                    @Override
                    public boolean addAll(Collection<? extends Runnable> c) {
                        return false;
                    }

                    @Override
                    public boolean removeAll(Collection<?> c) {
                        return false;
                    }

                    @Override
                    public boolean retainAll(Collection<?> c) {
                        return false;
                    }

                    @Override
                    public void clear() {

                    }
                });
        executor.execute(() -> System.out.println("1"));
    }
}
