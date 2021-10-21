package LeetCode.链表.q146_LRU缓存机制;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LRUCache
 * @Author audience
 * @Date 2021/8/30
 * @Version 1.0
 * @Description
 * 思路：维护一个map和一个双向链表，map的key存储Node节点的key，value存储Node节点本身
 *      链表用来添加和删除节点
 */
public class LRUCache {
    //定义Node
    private class Node{
        private int key;
        private int value;
        private Node pre;
        private Node next;
        public Node(){}
        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    //定义map
    private Map<Integer,Node> map = new HashMap();
    //长度
    private int size;
    //容量
    private int capacity;
    //虚拟头节点
    private Node head = new Node();
    //虚拟尾节点
    private Node tail = new Node();

    //将当前节点添加到虚拟头节点之后
    private void add(Node node){
        //原来的头节点
        Node originHead =head.next;
        //将当前节点添加到虚拟头节点之后
        head.next = node;
        //当前节点的pre
        node.pre = head;
        //当前节点的next
        node.next = originHead;
        //原来头节点的pre
        originHead.pre = node;
    }

    //删除当前节点
    private void delete(Node node){
        //当前节点的前后节点
        Node preNode = node.pre;
        Node nextNode = node.next;
        preNode.next = nextNode;
        nextNode.pre = preNode;
        node.next = null;
        node.pre = null;
    }

    //构造方法初始化LRUCache
    public LRUCache(int capacity){
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int key){
        Node node = map.get(key);
        if (node == null){
            return -1;
        }
        //删除当前节点
        delete(node);
        //添加到头部
        add(node);
        return node.value;
    }

    public void put(int key,int value){
        Node node = map.get(key);
        if (node!=null){
            node.value = value;
            //先删后加
            delete(node);
            add(node);
        }else {
            //长度不超过容量
            if (size<capacity){
                //长度加1
                size++;
            }else {
                //长度超过了容量，删除末尾元素
                //得到虚拟尾节点的上一个元素
                Node delNode = tail.pre;
                //从map中删除
                map.remove(delNode.key);
                //链表中删除
                delete(delNode);
            }
            //最后将根据key、value创建Node，加入到map和链表中
            Node addNode = new Node(key,value);
            map.put(key,addNode);
            add(addNode);
        }
    }

}
