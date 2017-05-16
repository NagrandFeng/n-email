package com.nagrand.email.client;

import com.nagrand.email.*;
import com.nagrand.email.excute.SendEmailException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.activation.FileDataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * 邮件工具类
 * 
 * @author Nagrand
 *
 */
public class MailTool {
	private MailTool() {
	}

	private static Log log = LogFactory.getLog(MailTool.class);

	/**
	 * 测试邮件发送是否正常。发送纯文本(标题和正文一样)
	 * 
	 *
	 * @throws IllegalAccessException
	 */
	public static SendResult test() {
		throw new RuntimeException("this method is unavalible");
		/*
		 * try { Properties p=Configuration.newPropertiesInstance(); String
		 * from=PropertiesTools.get(p, "xemail.from", ""); mail.send(testMsg,
		 * testMsg, null, from); } catch (Exception e) { e.printStackTrace(); }
		 */
	}

	/**
	 * 发送
	 * 
	 * @param instance
	 *            具体的邮箱实例
	 * @param subject
	 *            标题
	 * @param content
	 *            内容
	 * @param receivers
	 *            接收人
	 * @throws SendEmailException
	 */
	public static SendResult send(SendEmailable instance, String subject, String content, List<String> receivers)
			throws SendEmailException {
		// AbstractEmail mail = new SimpleEmail();
		return instance.send(subject, content, null, receivers);
	}

	/**
	 * 发送纯文本(标题和正文一样)
	 * 
	 * @param text
	 *            标题
	 * @param receiver
	 *            接收人
	 * @throws SendEmailException
	 */
	public static SendResult sendText(String text, String receiver) throws SendEmailException {
		AbstractEmail mail = new SimpleEmail();
		return mail.send(text, text, null, receiver);
	}

	/**
	 * 发送纯文本
	 * 
	 * @param subject
	 *            标题
	 * @param content
	 *            内容
	 * @param receiver
	 *            接收人
	 * @throws SendEmailException
	 */
	public static SendResult sendText(String subject, String content, String receiver) throws SendEmailException {
		AbstractEmail mail = new SimpleEmail();
		return mail.send(subject, content, null, receiver);
	}

	/**
	 * 发送带附件的（单个附件）
	 * 
	 * @param subject
	 *            标题
	 * @param content
	 *            内容
	 * @param fileDataSource
	 *            附件
	 * @param receiver
	 *            接收人
	 * @throws SendEmailException
	 */
	public static SendResult sendAttach(String subject, String content, FileDataSource fileDataSource, String receiver)
			throws SendEmailException {
		AbstractEmail mail = new AttachEmail();

		List<FileDataSource> fileDataSources = new ArrayList<FileDataSource>();
		fileDataSources.add(fileDataSource);
		return mail.send(subject, content, fileDataSources, receiver);
	}

	/**
	 * 发送带附件的（多个附件）
	 * 
	 * @param subject
	 *            标题
	 * @param content
	 *            内容
	 * @param fileDataSources
	 *            多个附件
	 * @param receiver
	 *            接收人
	 * @throws SendEmailException
	 */
	public static SendResult sendAttach(String subject, String content, List<FileDataSource> fileDataSources,
			String receiver) throws SendEmailException {
		AbstractEmail mail = new AttachEmail();
		try {
			return mail.send(subject, content, fileDataSources, receiver);
		} catch (Exception e) {
			log.error(e);
			throw new SendEmailException(e);
		}
	}

	/**
	 * 发送正文带图片的(单张图片)
	 * 
	 * @param subject
	 *            标题
	 * @param content
	 *            内容
	 * @param fileDataSource
	 *            图片
	 * @param receiver
	 *            接收人
	 * @throws SendEmailException
	 */
	public static SendResult sendImage(String subject, String content, FileDataSource fileDataSource, String receiver)
			throws SendEmailException {
		AbstractEmail mail = new ImageEmail();

		List<FileDataSource> fileDataSources = new ArrayList<FileDataSource>();
		fileDataSources.add(fileDataSource);
		return mail.send(subject, content, fileDataSources, receiver);
	}

	/**
	 * 发送正文带图片的(多张图片)
	 * 
	 * @param subject
	 *            标题
	 * @param content
	 *            内容
	 * @param fileDataSources
	 *            多个图片
	 * @param receiver
	 *            接收人
	 * @throws SendEmailException
	 */
	public static SendResult sendImage(String subject, String content, List<FileDataSource> fileDataSources,
			String receiver) throws SendEmailException {
		AbstractEmail mail = new ImageEmail();
		return mail.send(subject, content, fileDataSources, receiver);
	}

	/**
	 * 发送纯文本(标题和正文一样)
	 * 
	 * @param text
	 *            标题
	 * @param receivers
	 *            接收人
	 * @throws SendEmailException
	 */
	public static SendResult sendText(String text, List<String> receivers) throws SendEmailException {
		AbstractEmail mail = new SimpleEmail();
		return mail.send(text, text, null, receivers);
	}

	/**
	 * 发送纯文本
	 * 
	 * @param subject
	 *            标题
	 * @param content
	 *            内容
	 * @param receivers
	 *            接收人
	 * @throws SendEmailException
	 */
	public static SendResult sendText(String subject, String content, List<String> receivers)
			throws SendEmailException {
		AbstractEmail mail = new SimpleEmail();
		return mail.send(subject, content, null, receivers);
	}

	/**
	 * 发送带附件的（单个附件）
	 * 
	 * @param subject
	 *            标题
	 * @param content
	 *            内容
	 * @param fileDataSource
	 *            附件
	 * @param receivers
	 *            接收人
	 * @throws SendEmailException
	 */
	public static SendResult sendAttach(String subject, String content, FileDataSource fileDataSource,
			List<String> receivers) throws SendEmailException {
		AbstractEmail mail = new AttachEmail();

		List<FileDataSource> fileDataSources = new ArrayList<FileDataSource>();
		fileDataSources.add(fileDataSource);
		return mail.send(subject, content, fileDataSources, receivers);
	}

	/**
	 * 发送带附件的（多个附件）
	 * 
	 * @param subject
	 *            标题
	 * @param content
	 *            内容
	 * @param fileDataSources
	 *            多个附件
	 * @param receivers
	 *            接收人
	 * @throws SendEmailException
	 */
	public static SendResult sendAttach(String subject, String content, List<FileDataSource> fileDataSources,
			List<String> receivers) throws SendEmailException {
		AbstractEmail mail = new AttachEmail();
		return mail.send(subject, content, fileDataSources, receivers);
	}

	/**
	 * 发送正文带图片的(单张图片)
	 * 
	 * @param subject
	 *            标题
	 * @param content
	 *            内容
	 * @param fileDataSource
	 *            图片
	 * @param receivers
	 *            接收人
	 * @throws SendEmailException
	 */
	public static SendResult sendImage(String subject, String content, FileDataSource fileDataSource,
			List<String> receivers) throws SendEmailException {
		AbstractEmail mail = new ImageEmail();

		List<FileDataSource> fileDataSources = new ArrayList<FileDataSource>();
		fileDataSources.add(fileDataSource);
		return mail.send(subject, content, fileDataSources, receivers);
	}

	/**
	 * 发送正文带图片的(多张图片)
	 * 
	 * @param subject
	 *            标题
	 * @param content
	 *            内容
	 * @param fileDataSources
	 *            多个图片
	 * @param receivers
	 *            接收人
	 * @throws SendEmailException
	 */
	public static SendResult sendImage(String subject, String content, List<FileDataSource> fileDataSources,
			List<String> receivers) throws SendEmailException {
		AbstractEmail mail = new ImageEmail();
		return mail.send(subject, content, fileDataSources, receivers);
	}

}
