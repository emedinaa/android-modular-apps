package com.emedinaa.meetup.data.mapper;


import com.emedinaa.meetup.data.entity.MemberEntity;
import com.emedinaa.meetup.data.entity.PhotoEntity;
import com.emedinaa.meetup.domain.entity.Member;
import com.emedinaa.meetup.domain.entity.Photo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eduardo on 11/12/16.
 */
public class MemberMapper {

    public List<Member> transformList(List<MemberEntity> memberEntities){
        List<Member> members= new ArrayList<>();
        if(memberEntities==null) return members;
        for (MemberEntity memberEntity:memberEntities) {
            Member member= transform(memberEntity);
            members.add(member);
        }
        return  members;
    }

    public Member transform(MemberEntity memberEntity){
        Member member= new Member();
        if(memberEntity==null) return member;
        member.setId(memberEntity.getId());
        member.setName(memberEntity.getName());
        member.setCity(memberEntity.getCity());
        member.setJoined(memberEntity.getJoined());
        member.setCountry(memberEntity.getCountry());
        member.setLat(memberEntity.getLat());
        member.setLon(memberEntity.getLon());
        member.setStatus(memberEntity.getStatus());
        member.setPhoto(transformPhoto(memberEntity.getPhoto()));
        return  member;
    }

    private Photo transformPhoto(PhotoEntity photoEntity){
        Photo photo= new Photo();
        if(photoEntity==null) return photo;

        photo.setHighres_link(photoEntity.getHighres_link());
        photo.setPhoto_id(photoEntity.getPhoto_id());
        photo.setBase_url(photoEntity.getBase_url());
        photo.setType(photoEntity.getType());
        photo.setPhoto_link(photoEntity.getPhoto_link());
        photo.setThumb_link(photoEntity.getThumb_link());

        return photo;
    }
}
