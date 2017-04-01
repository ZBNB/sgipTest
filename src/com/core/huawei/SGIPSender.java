package com.core.huawei;

import java.util.*;
import java.util.Date;
import java.sql.*;
import java.io.*;

import com.huawei.smproxy.SGIPSMProxy;

import com.huawei.smproxy.comm.sgip.*;
import com.huawei.smproxy.comm.sgip.message.*;
import com.huawei.insa2.util.*;

public class SGIPSender extends SGIPSMProxy
{

	
	private static Map arg = Env.getConfig();

	private static SGIPSender instance;

	public static SGIPSender getInstance()
	{
		if (instance == null)
		{
			instance = new SGIPSender();
		}
		return instance;
	}

	protected SGIPSender() {
		super(SGIPSender.arg);
		startService("10.164.102.171", 8801);
	}

	public void OnTerminate()
	{
		System.out.println("Connection have been breaked! ");
	}

	public SGIPSubmitRepMessage send(SGIPSubmitMessage msg)
	{
		if (msg == null)
		{
			return null;
		}
		SGIPSubmitRepMessage reportMsg = null;

		try
		{
			reportMsg = (SGIPSubmitRepMessage) super.send(msg);
		} catch (IOException ex)
		{
			ex.printStackTrace();
			return null;
		}
		return reportMsg;
	}

	public static void main(String[] args)
	{

		SGIPSender sender = SGIPSender.getInstance();

		String SPNumber = "7777";
		String ChargeNumber = "";
		String[] UserNumber = {"8613100001111"};
		String CorpId = "";
		String ServiceType = "XW";
		int FeeType = 2;
		String FeeValue = "10";
		String GivenValue = "0";
		int AgentFlag = 0;
		int MorelatetoMTFlag = 2;
		int Priority = 0;
		Date ExpireTime = null;
		Date ScheduleTime = null;
		int ReportFlag = 0;
		int TP_pid = 0;
		int TP_udhi = 0;
		int MessageCoding = 0;
		int MessageType = 6;

		byte[] MessageContent = "this is test message!".getBytes();
		int MessageLen = MessageContent.length;

		String reserve = "0";

		SGIPSubmitMessage msg = null;

		msg = new SGIPSubmitMessage(SPNumber, ChargeNumber, UserNumber, CorpId,
		        ServiceType, FeeType, FeeValue, GivenValue, AgentFlag,
		        MorelatetoMTFlag, Priority, ExpireTime, ScheduleTime,
		        ReportFlag, TP_pid, TP_udhi, MessageCoding, MessageType,
		        MessageLen, MessageContent, reserve);

		SGIPSubmitRepMessage returnMsg = null;

		try
		{
			returnMsg  = sender.send(msg);
			if(null==returnMsg){
				System.out.println("send message failed!");
			}else{
				System.out.println(returnMsg);
			}


		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
