package Hello.hellospring.controller;


import Hello.hellospring.domain.Member;
import Hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired // 스프링에서 멤버 서비스를 자동 연결 시켜준다.
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/creatMemberForm"; // GET방식으로 해당 템플릿으로 이동
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName()); // setName에서 들어온 입력값을 getName으로 꺼내게됨

        memberService.join(member);

        return "redirect:/";//회원가입이 끝나면 홈 화면으로 전송
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

}
