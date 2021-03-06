package com.nsbt.mrs.domain.service.room

import com.nsbt.mrs.domain.repository.room.MeetingRoomRepository
import com.nsbt.mrs.domain.repository.room.ReservableRoomRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate

@Service
@Transactional
class RoomService(
    private val reservableRoomRepository: ReservableRoomRepository,
    private val meetingRoomRepository: MeetingRoomRepository
) {
    fun findReservableRooms(date: LocalDate) =
        reservableRoomRepository.findByReservableRoomId_reservedDateOrderByReservableRoomId_roomIdAsc(date)

    fun findMeetingRoom(roomId: Int) =
        meetingRoomRepository.findById(roomId).get()
}
