package com.spring.springGroupS.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.spring.springGroupS.dao.MemberDAO;
import com.spring.springGroupS.dao.StudyDAO;
import com.spring.springGroupS.vo.MemberVO;
import com.spring.springGroupS.vo.UserVO;

@Service
public class StudyServiceImpl implements StudyService {
	
	@Autowired
	StudyDAO studyDAO;
	@Autowired
	MemberDAO memberDAO;

	@Override
	public String[] getCityStringArray(String dodo) {
		String[] strArray = new String[100];
		
		if(dodo.equals("����")) {
			strArray[0] = "��珥�援�";
			strArray[1] = "媛��④뎄";
			strArray[2] = "媛���援�";
			strArray[3] = "����臾멸뎄";
			strArray[4] = "愿���援�";
			strArray[5] = "����援�";
			strArray[6] = "留��ш뎄";
			strArray[7] = "�≫��援�";
			strArray[8] = "�몄��援�";
			strArray[9] = "���깊�ш뎄";
		}
		else if(dodo.equals("寃쎄린")) {
			strArray[0] = "������";
			strArray[1] = "������";
			strArray[2] = "愿�紐���";
			strArray[3] = "������";
			strArray[4] = "���깆��";
			strArray[5] = "�깅�⑥��";
			strArray[6] = "���곗��";
			strArray[7] = "�⑹�몄��";
			strArray[8] = "�댁���";
			strArray[9] = "���깆��";
		}
		else if(dodo.equals("異⑸�")) {
			strArray[0] = "泥�二쇱��";
			strArray[1] = "異⑹＜��";
			strArray[2] = "��泥���";
			strArray[3] = "�⑥��援�";
			strArray[4] = "利���援�";
			strArray[5] = "�μ�援�";
			strArray[6] = "���깃뎔";
			strArray[7] = "����援�";
			strArray[8] = "吏�泥�援�";
			strArray[9] = "愿댁�곌뎔";
		}
		else if(dodo.equals("異⑸��")) {
			strArray[0] = "泥�����";
			strArray[1] = "���곗��";
			strArray[2] = "怨듭＜��";
			strArray[3] = "遺��ъ��";
			strArray[4] = "�쇱�곌뎔";
			strArray[5] = "援곗�곗��";
			strArray[6] = "���곗��";
			strArray[7] = "���깃뎔";
			strArray[8] = "湲��곌뎔";
			strArray[9] = "������";
		}
		
		return strArray;
	}

	@Override
	public ArrayList<String> getCityArrayList(String dodo) {
		ArrayList<String> vos = new ArrayList<String>();
		
		if(dodo.equals("����")) {
			vos.add("��珥�援�");
			vos.add("媛��④뎄");
			vos.add("媛���援�");
			vos.add("����臾멸뎄");
			vos.add("愿���援�");
			vos.add("����援�");
			vos.add("留��ш뎄");
			vos.add("�≫��援�");
			vos.add("�몄��援�");
			vos.add("���깊�ш뎄");
		}
		else if(dodo.equals("寃쎄린")) {
			vos.add("������");
			vos.add("������");
			vos.add("愿�紐���");
			vos.add("������");
			vos.add("���깆��");
			vos.add("�깅�⑥��");
			vos.add("���곗��");
			vos.add("�⑹�몄��");
			vos.add("�댁���");
			vos.add("���깆��");
		}
		else if(dodo.equals("異⑸�")) {
			vos.add("泥�二쇱��");
			vos.add("異⑹＜��");
			vos.add("��泥���");
			vos.add("�⑥��援�");
			vos.add("利���援�");
			vos.add("�μ�援�");
			vos.add("���깃뎔");
			vos.add("����援�");
			vos.add("吏�泥�援�");
			vos.add("愿댁�곌뎔");
		}
		else if(dodo.equals("異⑸��")) {
			vos.add("泥�����");
			vos.add("���곗��");
			vos.add("怨듭＜��");
			vos.add("遺��ъ��");
			vos.add("�쇱�곌뎔");
			vos.add("援곗�곗��");
			vos.add("���곗��");
			vos.add("���깃뎔");
			vos.add("湲��곌뎔");
			vos.add("������");
		}
		return vos;
	}

	@Override
	public ArrayList<UserVO> getUserList(String mid) {
		return studyDAO.getUserList(mid);
	}

	@Override
	public UserVO getUserMidSearch(String mid) {
		return studyDAO.getUserMidSearch(mid);
	}

	@Override
	public ArrayList<UserVO> getUserListSearch(String mid) {
		return studyDAO.getUserListSearch(mid);
	}

	@Override
	public int setFileUpload(MultipartFile fName, String mid) {
		int res = 0;
		
		// ���쇰� 以�蹂듭�由�
		String oFileName = fName.getOriginalFilename();
		String sFileName = mid + "_" + UUID.randomUUID().toString().substring(0,4) + "_" + oFileName;
		
		try {
			writeFile(fName, sFileName);
			res = 1;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return res;
	}

	// ���� ��踰��� ��濡��� ���ㅻ�� 硫�����
	private void writeFile(MultipartFile fName, String sFileName) throws IOException {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		String realPath = request.getSession().getServletContext().getRealPath("/resources/data/fileUpload/");
		
		FileOutputStream fos = new FileOutputStream(realPath + sFileName);
		
		if (fName.getBytes().length != -1) {
			fos.write(fName.getBytes());
		}
		fos.flush();
		fos.close();
	}

	@Override
	public List<MemberVO> getAddressList() {
		return memberDAO.getAddressList();
	}
}