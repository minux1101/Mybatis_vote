package com.vote.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vote.dto.CandidateVO;
import com.vote.dto.VoteVO;
import com.vote.service.CandidateService;
import com.vote.service.VoteService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class VoteController {

	private static final Logger logger = LoggerFactory.getLogger(VoteController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Inject
	CandidateService cs;

	@Inject
	VoteService vs;

	// selectAll Candidate
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String A1(Model model) throws Exception {

		List<CandidateVO> candidateList = cs.selectAll();
		model.addAttribute("CandidateList", candidateList);

		return "A_01";
	}

	// delete Candidate
	@RequestMapping(value = "/A_02", method = RequestMethod.GET)
	public String delete(@RequestParam int num, Model model) throws Exception {

		CandidateVO candidate = cs.selectOne(num);
		model.addAttribute("deleteCandidate", candidate);
		int delete = cs.delete(num); // memberServiceImpl

		return "A_02";
	}

	// insert Candidate
	@RequestMapping(value = "/A_03", method = { RequestMethod.GET, RequestMethod.POST })
	public String insert(HttpServletRequest request, Model model) throws Exception {

		CandidateVO candidateVO = new CandidateVO();
		request.setCharacterEncoding("UTF-8");

		if (request.getParameter("name2") == "" || request.getParameter("name2") == null) {
			return "A_01";
		} else {
			int num = Integer.parseInt(request.getParameter("num2"));
			String name = request.getParameter("name2");
			candidateVO.setNum(num);
			candidateVO.setName(name);
			model.addAttribute("insertCandidate", candidateVO);

			cs.insert(candidateVO);

			return "A_03";
		}
	}

	// selectAll Vote
	@RequestMapping(value = "/B_01", method = RequestMethod.GET)
	public String B1(Model model) throws Exception {

		List<CandidateVO> candidateList = cs.selectAll();
		model.addAttribute("CandidateList", candidateList);

		return "B_01";
	}

	// insert Vote
	@RequestMapping(value = "/B_02", method = { RequestMethod.GET, RequestMethod.POST })
	public String B2(HttpServletRequest request, Model model) throws Exception {

		VoteVO voteVO = new VoteVO();
		request.setCharacterEncoding("UTF-8");

		if (request.getParameter("candidate") == "" || request.getParameter("candidate") == null || request.getParameter("age") == "" || request.getParameter("age") == null) {
			return "B_01";
		} else {
			int num = Integer.parseInt(request.getParameter("candidate"));
			int age = Integer.parseInt(request.getParameter("age"));

			voteVO.setCddnum(num);
			voteVO.setAge(age);
			model.addAttribute("insertVote", voteVO);

			vs.insert(voteVO);

			return "B_02";
		}
	}

	// Vote Count
	@RequestMapping(value = "/C_01", method = RequestMethod.GET)
	public String C1(Model model) throws Exception {

		List<CandidateVO> candidateList = cs.selectAll();
		model.addAttribute("CandidateList", candidateList);

		List<Integer> countList = new ArrayList<Integer>();

		List<Integer> percentList = new ArrayList<Integer>();

		int count = vs.count();
		for (int i = 1; i <= candidateList.size(); i++) {
			int countCandidate_i = vs.countCandidate(candidateList.get(i - 1).getNum());
			countList.add(countCandidate_i);
			double percent_i = (double) countCandidate_i * 100.0 / count;
			percentList.add((int) Math.round(percent_i));
		}

		model.addAttribute("countList", countList);
		model.addAttribute("percentList", percentList);

		return "C_01";
	}

	// Vote Count Age
	@RequestMapping(value = "/C_02", method = RequestMethod.GET)
	public String C2(HttpServletRequest request, Model model) throws Exception {

		request.setCharacterEncoding("UTF-8");
		int num = Integer.parseInt(request.getParameter("candidatenum"));

		CandidateVO candidate = cs.selectOne(num);
		model.addAttribute("candidate", candidate);

		List<Integer> voteCandidateAge = vs.countAge(num);
		model.addAttribute("ageList", voteCandidateAge);

		List<Integer> age = new ArrayList<Integer>();
		List<Integer> agePercent = new ArrayList<Integer>();
		int countCandidate = vs.countCandidate(num);
		for (int i = 1; i < 10; i++) {
			age.add(i * 10);
			double percent_i = (double) voteCandidateAge.get(i - 1) * 100.0 / countCandidate;
			agePercent.add((int) Math.round(percent_i));
		}
		model.addAttribute("agePercent", agePercent);
		model.addAttribute("ageModel", age);

		return "C_02";
	}

}
