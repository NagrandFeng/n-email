package com.nagrand.email;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.List;

/**
 * 带附件的
 * @author Nagrand
 *
 */
public class AttachEmail extends AbstractEmail {

	public AttachEmail(boolean builtIn, String from, String pwd, String protocol, String host) {
		super(builtIn, from, pwd, protocol, host);
	}
	
	public AttachEmail() {
		super();
	}

	@Override
	protected Message createMail(String subject, String content, List<FileDataSource> fileDataSources, String receiver)
			throws Exception {
		return this.createAttachMail(subject, content, fileDataSources, receiver);
	}

	private MimeMessage createAttachMail(String subject, String content, List<FileDataSource> fileDataSources, String receiver)
			throws Exception {
		MimeMessage message = new MimeMessage(session);

		// 设置邮件的基本信息
		// 发件人
		message.setFrom(new InternetAddress(from));
		// 收件人
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
		// 邮件标题
		message.setSubject(subject);

		// 创建邮件正文，为了避免邮件正文中文乱码问题，需要使用charset=UTF-8指明字符编码
		MimeBodyPart mimeBodyPart = new MimeBodyPart();
		mimeBodyPart.setContent(content, "text/html;charset=UTF-8");
		// 创建容器描述数据关系
		MimeMultipart mp = new MimeMultipart();
		mp.addBodyPart(mimeBodyPart);
		// 创建邮件附件
		for(int i=0;i<fileDataSources.size();i++){
			MimeBodyPart attach = new MimeBodyPart();
			DataHandler dh = new DataHandler(fileDataSources.get(i));
			attach.setDataHandler(dh);
			attach.setFileName(dh.getName());
			mp.addBodyPart(attach);
		}
		mp.setSubType("mixed");
		message.setContent(mp);
		message.saveChanges();
		// 将创建的Email写入盘存储
		//store(message);
		// 返回生成的邮件
		return message;
	}


}
