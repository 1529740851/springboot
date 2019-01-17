package com.example.demo.Main;

import com.example.demo.entity.ListNode;

public class LinkMain {
	
	public static void set(ListNode old,ListNode newNode ){
		old.next=newNode;
		newNode.next=null;
	}
	
	public static void resume(ListNode head ){
		while(head!=null){
			System.out.println(head.value);
			head=head.next;
		}
	}

	public static int find(ListNode head ,int value){
		int index=-1;
		int count=0;
		while(head!=null){
			if(head.value==value){
				return count;
			}
			count++;
			head=head.next;
		}
		return index;
	}

	public static void delete(ListNode head ,ListNode del){
		if(del!=null&&del.next!=null){
			ListNode old=del.next;
			del.value=old.value;
			del.next=old.next;
		}
		if(del.next==null){
			while(head!=null){
				if(head.next!=null&&head.next==del){
					head.next=null;
					break;
				}
				head=head.next;
			}
		}
	}

	public static void main(String[] args){
		ListNode node0= new  ListNode(0);
		ListNode node1= new  ListNode(1);
		ListNode node2= new  ListNode(2);
		node0.next=node1;
		node1.next=node2;
		node2.next=null;
		resume(node0);
		ListNode node3= new  ListNode(3);
		set(node2,node3);
		resume(node0);
		delete(node0,node3);
		resume(node0);
	}
	
	
}
