package com.capstone.chatting.DTO;

import com.capstone.chatting.domain.GroupChatRoom;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class GroupChatRoomDto {
    private Long mid1;
    private Long mid2;
    private Long mid3;
    private Long mid4;
    private Long mid5;
    private Long mid6;
    private Long jerryId;

    public GroupChatRoomDto(Long mid1, Long mid2, Long mid3, Long mid4, Long mid5, Long mid6, Long jerryId) {
        this.mid1 = mid1;
        this.mid2 = mid2;
        this.mid3 = mid3;
        this.mid4 = mid4;
        this.mid5 = mid5;
        this.mid6 = mid6;
        this.jerryId = jerryId;
    }

    public GroupChatRoom createGroupChatRoom(){
        return new GroupChatRoom(mid1,mid2,mid3,mid4,mid5,mid6,jerryId);
    }
}
