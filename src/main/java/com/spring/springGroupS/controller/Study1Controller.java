package com.spring.springGroupS.controller;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.springGroupS.common.ARIAUtil;
import com.spring.springGroupS.common.SecurityUtil;
import com.spring.springGroupS.service.Study1Service;
import com.spring.springGroupS.service.StudyService;
import com.spring.springGroupS.vo.HoewonVO;
import com.spring.springGroupS.vo.MailVO;
import com.spring.springGroupS.vo.MemberVO;
import com.spring.springGroupS.vo.SiteInfor2VO;
import com.spring.springGroupS.vo.SiteInforVO;
import com.spring.springGroupS.vo.SungjukVO;
import com.spring.springGroupS.vo.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/study1")
public class Study1Controller {
	
	@Autowired
	JavaMailSender mailSender;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	Study1Service study1Service;
	
	@Autowired
	StudyService studyService;
	
	// QueryString 諛⑹���� �듯�� 媛��� ����
	
	//@RequestMapping(value = "/study1/mapping/test1", method = RequestMethod.GET)
	@GetMapping("/mapping/menu")
	public String menuGet() {
		return "study1/mapping/menu";
	}
	
	@GetMapping("/mapping/test1")
	public String test1Get(HttpServletRequest request) {
		String mid = request.getParameter("mid");
		String pwd = request.getParameter("pwd");
		
		request.setAttribute("mid", mid);
		request.setAttribute("pwd", pwd);
		
		return "study1/mapping/test01";
	}
	
	@GetMapping("/mapping/test2")
	public String test2Get(Model model, String mid, String pwd) {
		model.addAttribute("mid", mid);
		model.addAttribute("pwd", pwd);
		return "study1/mapping/test02";
	}
	
	@GetMapping("/mapping/test3")
	public String test3Get(Model model, 
			@RequestParam(name="mid") String id, 
			@RequestParam(name="pwd") String passwd
		) {
		model.addAttribute("mid", id);
		model.addAttribute("pwd", passwd);
		return "study1/mapping/test03";
	}
	
	@GetMapping("/mapping/test4")
	public String test4Get(Model model, 
			@RequestParam(name="mid") String id, 
			@RequestParam(name="pwd") String passwd,
			@RequestParam(name="name", defaultValue = "����", required = false) String name,
			@RequestParam(name="sex") int sex
			) {
		
		String gender = "";
		if(sex == 1 || sex == 3) gender = "�⑥��";
		else if(sex == 2 || sex == 4) gender = "�ъ��";
		else gender = "以���";
		
		model.addAttribute("mid", id);
		model.addAttribute("pwd", passwd);
		model.addAttribute("name", name);
		model.addAttribute("gender", gender);
		return "study1/mapping/test04";
	}
	
	@GetMapping("/mapping/test5")
	public String test5Get(Model model, String mid, String pwd, String name, String gender, int age) {
		model.addAttribute("mid", mid);
		model.addAttribute("pwd", pwd);
		model.addAttribute("name", name);
		model.addAttribute("gender", gender);
		model.addAttribute("age", age);
		return "study1/mapping/test05";
	}
	
	@GetMapping("/mapping/test6")
	public String test6Get(Model model, String mid, String pwd, String name, String gender, int age) {
		HoewonVO vo = new HoewonVO();
		
		vo.setMid(mid);
		vo.setPwd(pwd);
		vo.setName(name);
		vo.setGender(gender);
		vo.setAge(age);
		
		model.addAttribute("vo", vo);
		return "study1/mapping/test06";
	}
	
	@GetMapping("/mapping/test7")
	public String test7Get(Model model, String mid, String pwd, String name, String gender, int age, HoewonVO vo) {
		//HoewonVO vo = new HoewonVO();
		
		vo.setMid(mid);
		vo.setPwd(pwd);
		vo.setName(name);
		vo.setGender(gender);
		vo.setAge(age);
		
		model.addAttribute("vo", vo);
		return "study1/mapping/test07";
	}
	
	@GetMapping("/mapping/test8")
	public String test8Get(Model model, HoewonVO vo) {
		model.addAttribute("vo", vo);
		return "study1/mapping/test08";
	}
	
	@GetMapping("/mapping/test9")
	public ModelAndView test9Get(HoewonVO vo) {
		ModelAndView mv = new ModelAndView("study1/mapping/test09");
		mv.addObject("vo", vo);
		return mv;
	}
	
	/* ---------------------------------------------- */
	
	// Path Variable諛⑹���쇰��� 媛����ъ�곗��
	@GetMapping("/mapping/test21/{mid}/{pwd}")
	public String test21Get(Model model, @PathVariable String mid, @PathVariable String pwd) {
		model.addAttribute("mid", mid);
		model.addAttribute("pwd", pwd);
		return "study1/mapping/test21";
	}
	
	@GetMapping("/mapping/test22/{id}/{passwd}")
	public String test22Get(Model model, @PathVariable String id, @PathVariable String passwd) {
		model.addAttribute("mid", id);
		model.addAttribute("pwd", passwd);
		return "study1/mapping/test22";
	}
	
	@GetMapping("/mapping/{passwd}/test23/{id}")
	public String test23Get(Model model, @PathVariable String id, @PathVariable String passwd) {
		model.addAttribute("mid", id);
		model.addAttribute("pwd", passwd);
		return "study1/mapping/test23";
	}
	
	@GetMapping("/mapping/{passwd}/{temp}/test24/{id}")
	public String test24Get(Model model, @PathVariable String id, @PathVariable String passwd) {
		model.addAttribute("mid", id);
		model.addAttribute("pwd", passwd);
		return "study1/mapping/test24";
	}
	
	@GetMapping("/mapping/test25/{mid}/{pwd}/{name}/{temp}/{gender}/{age}")
	public String test25Get(Model model, HoewonVO vo
		) {
		model.addAttribute("vo", vo);
		return "study1/mapping/test25";
	}
	
	/* ====================================================== */
	
	// Post諛⑹���� ���� 媛��� ����
	
	//@GetMapping("/mapping/test31")
	//@RequestMapping(value = "/mapping/test31", method = RequestMethod.POST)
	@PostMapping("/mapping/test31")
	public String test31Post(Model model, HoewonVO vo,
			String mid,
			String pwd,
			String name,
			String gender,
			String strGender,
			int age,
			String nickName			
		) {
		
		vo.setMid(mid);
		vo.setPwd(pwd);
		vo.setName(name);
		vo.setGender(strGender);
		//vo.setStrGender(strGender);
		vo.setAge(age);
		vo.setNickName(nickName);
		
		model.addAttribute("vo", vo);
		return "study1/mapping/test31";
	}
	
	@PostMapping("/mapping/test32")
	public String test32Post(Model model, HoewonVO vo) {
		model.addAttribute("vo", vo);
		return "study1/mapping/test32";
	}
	
	@GetMapping("/mapping/test33")
	public String test33Get(Model model, String mid, HoewonVO vo) {
		// ���대��濡� DB���� ������蹂대�� 媛��몄���� VO�� �댁���� jsp濡� ��寃⑥���.
		vo.setMid(mid);
		
		model.addAttribute("vo", vo);
		
		return "study1/mapping/test33";
	}
	
	@PostMapping("/mapping/test33")
	public String test33Post(Model model, HoewonVO vo) {
		// DB�� ���� ��蹂대�� ���μ���⑤��.(����媛���泥�由�)
		
		// ���� 媛����� 硫��몄�泥�由ы����.
		model.addAttribute("message", vo.getMid() + "�� ���� 媛��� �����듬����.");
		model.addAttribute("url", "/study1/mapping/test33");
		model.addAttribute("mid", vo.getMid());
//		model.addAttribute("url","/study1/mapping/test33?mid="+vo.getMid());
		return "include/message";
	}
	
	@PostMapping("/mapping/test34")
	public String test34Post(Model model, HoewonVO vo) {
	  // DB�� ���� ��蹂대�� ���μ���⑤��.(����媛���泥�由�)
		System.out.println("1.�닿납�� ���� ��蹂대�� DB�� ���μ�由ы��怨� ���듬����.");
		
		model.addAttribute("message","���� 媛��� �����듬����.");
		model.addAttribute("vo", vo);
		
		return "study1/mapping/test34";
	}
	
	@GetMapping("/mapping/test35")
	public String test35Get(Model model, HoewonVO vo) {
		// ���대��濡� DB���� ������蹂대�� 媛��몄���� VO�� �댁���� jsp濡� ��寃⑥���.
		// vo.setMid(mid);
		
		model.addAttribute("vo", vo);
		
		return "study1/mapping/test35";
	}
	
	@PostMapping("/mapping/test35")
	public String test35Post(Model model, HoewonVO vo) {
		// �������대���� 泥リ���媛� 'a'濡� �������� ����留� 媛���泥�由ы����濡� ����.
		
		if(vo.getMid().substring(0, 1).equals("a")) {
			// DB�� ���� ��蹂대�� ���μ���⑤��.(����媛���泥�由�)
			System.out.println("2.�닿납�� ���� ��蹂대�� DB�� ���μ�由ы��怨� ���듬����.");
			return "redirect:/message/hoewonInputOk?mid="+vo.getMid();
		}
		else return "redirect:/message/hoewonInputNo";
	}
	
	@GetMapping("/aop/aopMenu")
	public String aopMenuGet() {
		log.info("study1而⑦�몃·�ъ�� aopMenu硫�����������.");
		return "study1/aop/aopMenu";
	}
	
	@GetMapping("/aop/test1")
	public String aopTest1Get() {
		log.info("study1而⑦�몃·�ъ�� test1硫�����������.");
		
		//Study1Service service = new Study1Service();
		//service.getAopServiceTest1();
		
		study1Service.getAopServiceTest1();
		
		return "study1/aop/aopMenu";
	}
	
	@GetMapping("/aop/test2")
	public String aopTest2Get() {
		log.info("study1而⑦�몃·�ъ�� test2硫�����������.");
		
		study1Service.getAopServiceTest2();
		
		return "study1/aop/aopMenu";
	}
	
	@GetMapping("/aop/test3")
	public String aopTest3Get() {
		log.info("study1而⑦�몃·�ъ�� test3硫�����������.");
		
		study1Service.getAopServiceTest3();
		
		return "study1/aop/aopMenu";
	}
	
	@GetMapping("/aop/test4")
	public String aopTest4Get() {
		log.info("study1而⑦�몃·�ъ�� test4硫�����������.");
		
		study1Service.getAopServiceTest52();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		study1Service.getAopServiceTest53();
		
		return "study1/aop/aopMenu";
	}
	
	@GetMapping("/aop/test5")
	public String aopTest5Get() {
		// log.info("study1而⑦�몃·�ъ�� test5硫�����������.");
		
		study1Service.getAopServiceTest1();
		study1Service.getAopServiceTest2();
		study1Service.getAopServiceTest3();
		study1Service.getAopServiceTest52();
		study1Service.getAopServiceTest53();
		
		return "study1/aop/aopMenu";
	}
	
	// XML 媛� 二쇱���곗�� 硫���
	@GetMapping("/xml/xmlMenu")
	public String xmlMenuGet() {
		return "study1/xml/xmlMenu";
	}
	
	@GetMapping("/xml/xmlTest1")
	public String xmlTest1Get(Model model) {
		AbstractApplicationContext context = new GenericXmlApplicationContext("xml/sungjuk.xml");
		
//		SungjukVO vo1 = context.getBean("vo1", SungjukVO.class);
//		System.out.println("vo1 : " + vo1);
//		
//		SungjukVO vo2 = context.getBean("vo2", SungjukVO.class);
//		System.out.println("vo2 : " + vo2);
//		
//		SungjukVO vo3 = context.getBean("vo3", SungjukVO.class);
//		System.out.println("vo3 : " + vo3);
		
		List<SungjukVO> vos = new ArrayList<SungjukVO>();
		SungjukVO vo = null;
		for(int i=1; i<=3; i++) {
			String str = "vo" + i;
			vo = context.getBean(str, SungjukVO.class);
			vos.add(vo);
		}
		
		model.addAttribute("vos", vos);
		
		context.close();
		return "study1/xml/xmlTest1";
	}
	
	@GetMapping("/xml/xmlTest2")
	public String xmlTest2Get(Model model) {
		AbstractApplicationContext context = new GenericXmlApplicationContext("xml/sungjuk.xml");
		
		List<SungjukVO> vos = new ArrayList<SungjukVO>();
		SungjukVO vo = null;
		for(int i=1; i<=3; i++) {
			String str = "vo" + i;
			vo = context.getBean(str, SungjukVO.class);
			//vo = study1Service.getSungjukCalc(vo);
			vos.add(vo);
		}
		
		model.addAttribute("vos", vos);
		
		context.close();
		return "study1/xml/xmlTest2";
	}
	
	@GetMapping("/xml/xmlTest3")
	public String xmlTest3Get(Model model) {
		AbstractApplicationContext context = new GenericXmlApplicationContext("xml/siteInfor.xml");
		
		SiteInforVO vo = context.getBean("infor", SiteInforVO.class);
		
		model.addAttribute("vo", vo);
		
		context.close();
		return "study1/xml/xmlTest3";
	}
	
	@GetMapping("/xml/xmlTest4")
	public String xmlTest4Get(Model model) {
		AbstractApplicationContext context = new GenericXmlApplicationContext("xml/siteInforP.xml");
		
		SiteInfor2VO vo = context.getBean("infor", SiteInfor2VO.class);
		
		model.addAttribute("vo", vo);
		
		context.close();
		return "study1/xml/xmlTest3";
	}
	
	@GetMapping("/xml/xmlTest5")
	public String xmlTest5Get(Model model) {
		AbstractApplicationContext context = new GenericXmlApplicationContext("xml/bmi.xml");
		
		
		for(int i=1; i<=50; i++) {
			String str = "person" + i;
			// vo = study1Service.getBmiCalc(vo);
		}
		
		
		context.close();
		return "study1/xml/xmlTest5";
	}
	
	// restApi �쇰낫湲�
	@GetMapping("/restApi/restApiForm")
	public String restApiFormGet() {
		return "study1/restApi/restApiForm";
	}
	
	// REST API瑜� �듯�� �쇰� 硫��몄� 泥�由�1(X)
	@GetMapping("/restApi/test1/{message}")
	public String restApiTest1Get(@PathVariable String message) {
		System.out.println("message : " + message);
		return "message : " + message;
	}
	
	// REST API瑜� �듯�� �쇰� 硫��몄� 泥�由�2(O)
	@ResponseBody
	@GetMapping("/restApi/test2/{message}")
	public String restApiTest2Get(@PathVariable String message) {
		System.out.println("message : " + message);
		return "message : " + message;
	}
	
	// AJax �쇰낫湲�
	@GetMapping("/ajax/ajaxForm")
	public String ajaxFormGet() {
		return "study1/ajax/ajaxForm";
	}
	
	// �쇰� 媛� 泥�由�
	@ResponseBody
	@GetMapping("/ajax/ajaxTest1")
	public String ajaxTest1Get(int item) {
		return "item = " + item;
	}
	
	// AJax �レ��媛� 泥�由�
	@ResponseBody
	@PostMapping("/ajax/ajaxTest2")
	public int ajaxTest2Get(int item) {
		return item;
	}
	
	// AJax 臾몄��媛� 泥�由�
	@ResponseBody
	@PostMapping("/ajax/ajaxTest3")
	public String ajaxTest3Post(String item) {
		return "item = " + item;
	}
	
	// AJax 媛�泥� ���� �쇰낫湲�
	@GetMapping("/ajax/ajaxObjectForm")
	public String ajaxObjectFormGet() {
		return "study1/ajax/ajaxObjectForm";
	}
	
	// ajax泥�由ш껐怨쇰�� 諛곗��(String諛곗��)濡� ����...
	@ResponseBody
	@PostMapping("/ajax/ajaxObject1")
	public String[] ajaxObject1Post(String dodo) {
//		String[] strArray = new String[100];
//		strArray = studyService.getCityStringArray(dodo);
//		return strArray;
		return studyService.getCityStringArray(dodo);
	}
	
	// ajax泥�由ш껐怨쇰�� 媛�泥대같��(ArrayList<String>)濡� ����...
	@ResponseBody
	@PostMapping("/ajax/ajaxObject2")
	public ArrayList<String> ajaxObject2Post(String dodo) {
		return studyService.getCityArrayList(dodo);
	}
	
	// ajax泥�由ш껐怨쇰�� 媛�泥대같��(Map<Object, Object>)濡� ����...
	@ResponseBody
	@PostMapping("/ajax/ajaxObject3")
	public Map<Object, Object> ajaxObject3Post(String dodo) {
		ArrayList<String> vos = studyService.getCityArrayList(dodo);
		
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("city", vos);
		return map;
	}
	
	// 媛�泥대같��(arrayList)濡� ����...
	@PostMapping("/ajax/ajaxObject4")
	public String ajaxObject4Post(Model model, String mid) {
		ArrayList<UserVO> vos = studyService.getUserList(mid);
		model.addAttribute("vos", vos);
		
		return "study1/ajax/ajaxObjectForm";
	}
	
	// vo媛�泥대� ����...
	@ResponseBody
	@PostMapping("/ajax/ajaxObject5")
	public UserVO ajaxObject5Post(String mid) {
		return studyService.getUserMidSearch(mid);
	}
	
	// vo媛�泥대� ����...
		@ResponseBody
		@PostMapping("/ajax/ajaxObject6")
		public ArrayList<UserVO> ajaxObject6Post(String mid) {
			return studyService.getUserList(mid);
		}
		
	// vo媛�泥대� ����...
		@ResponseBody
		@PostMapping("/ajax/ajaxObject7")
		public ArrayList<UserVO> ajaxObject7Post(String mid) {
			return studyService.getUserListSearch(mid);
		}
		
		@GetMapping("/password/passwordForm")
		public String passwordFormGet() {
			return "study1/password/passwordForm";
		}
		
		// sha256���명��(ajax 泥�由�)
		@ResponseBody()
		@PostMapping("/password/sha256")
		public String sha256Post(String pwd) {
			String salt = UUID.randomUUID().toString().substring(0,8);
			SecurityUtil security = new SecurityUtil();
			String encPwd = security.encryptSHA256(salt+pwd);
			pwd = "salt: " + salt + " / ���명���� 鍮�諛�踰���: " + encPwd;
			return pwd;
		}
		
		// aria���명��(ajax 泥�由�)
		@ResponseBody()
		@PostMapping(value="/password/aria", produces="application/text; charset=utf8")
		public String ariaPost(String pwd) throws InvalidKeyException, UnsupportedEncodingException {
			String salt = UUID.randomUUID().toString().substring(0,8);
			
			String encPwd = ARIAUtil.ariaEncrypt(salt + pwd);
			String decPwd = ARIAUtil.ariaDecrypt(encPwd);
			
			pwd = "salt: " + salt + " / ���명���� 鍮�諛�踰���: " + encPwd + " / 蹂듯�명�� 鍮�踰�: " + decPwd.substring(8);
			return pwd;
		}
		
		// BCryptPasswordEncoder���명��(ajax 泥�由�)
		@ResponseBody()
		@PostMapping(value="/password/bCryptpassword", produces="application/text; charset=utf8")
		public String bCryptPasswordPost(String pwd) throws InvalidKeyException, UnsupportedEncodingException {
			
			String encPwd = passwordEncoder.encode(pwd);
			
			System.out.println("encPwd : " + encPwd);
			
			pwd = "���명���� 鍮�諛�踰���: " + encPwd;
			return pwd;
		}
		
		// 주소록
		@GetMapping("/mail/mailForm")
		public String mailFormGet(Model model) {			
			List<MemberVO> memberVos = studyService.getAddressList();
		
			model.addAttribute("memberVos", memberVos);	
			
			return "study1/mail/mailForm";
		} 
		
		// 메일보내기
		@PostMapping("/mail/mailForm")
		public String mailFormPost(MailVO vo, HttpServletRequest request) throws MessagingException {
			String toMail = vo.getToMail();
			String title = vo.getTitle();
			String content = vo.getContent();
			
			// 硫��� ���≪�� ���� 媛�泥�: MimeMessage(), MimeMessageHelper()
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			
			// 硫��몄� 蹂닿��⑥�� ���λ���� content 蹂������� 諛������� ������ ��蹂대�� 異�媛�濡� �댁��以���.
			content = content.replace("\n", "<br>");
			content += "<br><hr><h3>SpringGroup���� 蹂대������.</h3><hr><br>";
			content += "<p><img src=\"cid:image.jpg\" width='500px'></p>";
			content += "<p>諛⑸Ц��湲�: <a href='http://49.142.157.251:9090/cjgreen'>springGroup</a></p>";
			content += "<hr>";
			messageHelper.setTo(toMail);
			messageHelper.setSubject(title);
			messageHelper.setText(content, true);
			
			/*FileSystemResource file = new FileSystemResource("D:\\springGroup\\springframework\\works\\springGroupS\\src\\main\\webapp\\resources\\images\\image.jpg");*/
			FileSystemResource file = new FileSystemResource(request.getSession().getServletContext().getRealPath("/resources/images/image.jpg"));
			messageHelper.addInline("image.jpg", file);
			
			// 泥⑤����� 蹂대�닿린
			file = new FileSystemResource(request.getSession().getServletContext().getRealPath("/resources/images/2.jpg"));
			messageHelper.addAttachment("2.jpg", file);
			file = new FileSystemResource(request.getSession().getServletContext().getRealPath("/resources/images/3.jpg"));
			messageHelper.addAttachment("3.jpg", file);
			
			// 메일보내기
			mailSender.send(message);
			
			return "redirect:/message/mailSendOk";
		}
		
			// 파일업로드
			@GetMapping("/fileUpload/fileUploadForm")
			public String fileUploadFormGet() {			
				return "study1/fileUpload/fileUploadForm";
			}
			
			// 파일업로드
			@PostMapping("/fileUpload/fileUploadForm")
			public String fileUploadFormPost(MultipartFile fName, String mid) {			
				int res = studyService.setFileUpload(fName, mid);
				
				if (res != 0) return "redirect:/message/fileUploadOk";
				else return "redirect:/message/fileUploadNo";
			}
}
